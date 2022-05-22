import AppTourList from "./app-tour-list.js";
import JsonTourList from "./json-tour-list.js";
import ValidationNotification from "./validation-notification.js";
import {postRequest} from "./api.js";



export const PROCESS = {
    LOADING: 'Loading...',
    FINISHED: 'Completed',
    FAILED: 'Failed'
};
function getRandomNumber() {
    return Math.random().toFixed(1) ;
}


function pubsub() {
    let events = {};
    function publish(event,data, id){
        if(id) {
            let pair = events[event].find(pairObj => pairObj.id == id);
            pair.func(data);
        }else {
            events[event].forEach(pairObj => pairObj.func(data));
        }
    }
    function subscribe(event, func, id) {
        if(!events[event])
            events[event] = [];
        if(id){
            events[event].push({id, func});
            return id;
        }else{
            let newId = events[event].length;
            events[event].push({id: newId, func});
            return newId;
        }
    }
    function unsubscribe(event , id){
        events[event] = events[event].filter((pair) => pair.id == id);

    }
    return {
        publish,
        subscribe,
        unsubscribe
    }
}
export const tourPubsub = pubsub();



async function tourValidation (tour) {
    //validating
    const randomNumber = getRandomNumber() * 10;
    wait(randomNumber * 1000).then(() => {
        const isValid = randomNumber > 5;
        tourPubsub.publish('tour-validation', {isValid, tourId: tour.id} );
        // tourPubsub.publish('tour-counter', isValid );
    })
}

const wait = num => new Promise(resolve => setTimeout(resolve, num));
const omitKey = (key, { [key]: _, ...obj }) => obj



class TourPage {
    jsonList = {};
    serverList = {};
    validationNotification = {};
    timout = null;
    processingItems = {};


    constructor() {
        this.jsonList = new JsonTourList();
        this.serverList = new AppTourList();
        this.validationNotification = new ValidationNotification();
    }

    renderJsonTourList() {
        const list = this.jsonList.render();
        list.classList.add('tours-json');
        return list;
    }
    removeValidation() {
        this.timout = setTimeout( () => {
            this.validationNotification.container.classList.add('hide');
        } , 1000)
    }

    async removeNotification(tour) {
        return wait(2000).then(() => this.validationNotification.removeTour(tour.id)).then(() => {
            this.processingItems = omitKey(tour.id, this.processingItems);
            if (Object.keys(this.processingItems).length === 0) this.removeValidation();
        });
    }

    async onProcessFinished(tour) {
        this.validationNotification.setTourStatus(tour.id, PROCESS.FINISHED, ['tour__status-success']);
        this.serverList.addNewItem(tour);
        this.jsonList.removeItem(tour.id);
        postRequest(omitKey('checked', tour), 'http://localhost:8080/app/admin'); //TODO
        return this.removeNotification(tour);
    }
    async onProcessFailed(tour) {
        this.validationNotification.setTourStatus(tour.id, PROCESS.FAILED , ['tour__status-failed']);
        this.jsonList.enableItem(tour.id);
        this.jsonList.setFailMode(tour.id);
        return this.removeNotification(tour);
    }

    renderAddButton () {
        const btn = document.createElement('button');
        btn.classList.add('tours__add-btn');
        btn.textContent = 'Add';
        btn.addEventListener('click' , () => {
            let checkedTours = this.jsonList.checkItems;

           clearTimeout(this.timout);
           checkedTours
              .filter((tr) => !this.processingItems[tr.id])
              .map(tr => {
                  this.processingItems[tr.id] = tr;
                  this.jsonList.disableItem(tr.id);
                  this.validationNotification.addTour(tr);
                  this.validationNotification.setTourStatus(tr.id, PROCESS.LOADING, ['tour__status-loading']);
                  return tr;
           })
              .forEach(tr => {
                  tourPubsub.subscribe('tour-validation', function ({isValid ,tourId}) {
                      if (tourId == tr.id) {
                          isValid ? this.onProcessFinished(tr)
                              : this.onProcessFailed(tr)
                      }
                  }.bind(this), tr.id);
                  tourValidation(tr);
              });



        })
        return btn;
    }

    renderAppTourList() {
        const tourList = this.serverList.render();
        this.serverList.initTours();
        tourList.classList.add('tours-server');
        tourPubsub.subscribe('tour-validation', ({isValid, tourId}) => this.serverList.countItem(isValid));
        return tourList;
    }
    renderValidationNotification() {
        return this.validationNotification.render();
    }
    renderTours() {
        const tourList = document.createElement('div');
        tourList.classList.add('tours');
        tourList.appendChild(this.renderJsonTourList());
        tourList.appendChild(this.renderAddButton());
        tourList.appendChild(this.renderAppTourList());
        return tourList;
    }




    render() {
        const container = document.createElement('div');
        container.classList.add('tour-container');
        container.appendChild(this.renderTours());
        container.appendChild(this.renderValidationNotification())
        return container;
    }
}

const root = document.getElementById("tour-page");
const tourPage = new TourPage();
root.appendChild(tourPage.render());


