import AppTourList from "./app-tour-list.js";
import JsonTourList from "./json-tour-list.js";
import ValidationNotification from "./validation-notification.js";



export const STATUS = {
    LOADING: 'Loading...',
    FINISHED: 'Completed',
    FAILED: 'Failed'
};
function getRandomNumber() {
    return Math.random().toFixed(1) * 10000;
}

export async function mockValidation (tr) {
    return new Promise((resolve) => {
        const num = getRandomNumber();
        setTimeout(() => {
            resolve(num);
        }, num );
    }).then( () => {
        let ran = getRandomNumber() / 1000;
        return ran > 5;
    }) ;

}

const wait = num => new Promise(resolve => setTimeout(resolve, num));

class TourPage {
    jsonList = {};
    serverList = {};
    validationNotification = {};
    timout = null;


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
        } , 2000)
    }
    renderAddButton () {
        const btn = document.createElement('button');
        btn.classList.add('tours__add-btn');
        btn.textContent = 'Add';
        btn.addEventListener('click' , () => {
            let checkedTours = this.jsonList.checkItems;
            // let tours = this.validationNotification.addTours(checkedTours);

           clearTimeout(this.timout);
          const items = checkedTours.map(tr => {
              this.jsonList.disableItem(tr.id);
               this.validationNotification.addTour(tr);
               this.validationNotification.setTourStatus(tr.id , STATUS.LOADING, ['tour__status-loading'] );
               return tr;
           }).map(async tr => {
               const isValid = await mockValidation(tr);
               if(isValid) {
                   this.validationNotification.setTourStatus(tr.id, STATUS.FINISHED, ['tour__status-success']);
                   this.serverList.addItem(tr);
                   this.jsonList.removeItem(tr.id);
                   wait(2000).then(() => this.validationNotification.removeTour(tr.id));
                   return tr;
               }
               this.validationNotification.setTourStatus(tr.id, STATUS.FAILED , ['tour__status-failed']);
              this.jsonList.enableItem(tr.id);
              this.jsonList.tagItem(tr.id);
               wait(2000).then(() => this.validationNotification.removeTour(tr.id));

               return null;

           }).filter(tr => tr);

           Promise.all(items).then(() => {
               this.removeValidation();
           });
        })
        return btn;
    }

    renderAppTourList() {
        const tourList = this.serverList.render();
        tourList.classList.add('tours-server');
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

