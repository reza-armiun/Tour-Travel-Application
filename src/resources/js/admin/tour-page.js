import TourList from "./tour-list.js";
import JsonTourList from "./json-tour-list.js";
import TourValidation from "./tour-validation.js";




class TourPage {
    jsonList = {};
    serverList = {};
    validator = null;
    timout = null;


    constructor(validator) {
        this.jsonList = new JsonTourList();
        this.serverList = new TourList();
        this.validator = validator;
    }

    renderJsonTourList() {
        const list = this.jsonList.render();
        list.classList.add('tours-json');
        return list;
    }
    removeValidation() {
        this.timout = setTimeout( () => {
            this.validator.container.classList.add('hide');
        } , 2000)
    }
    renderAddButton () {
        const btn = document.createElement('button');
        btn.classList.add('tours__add-btn');
        btn.textContent = 'Add';
        btn.addEventListener('click' , () => {
            let checkItems = this.jsonList.checkItems;
            let tours = this.validator.addTours(checkItems);

           clearTimeout(this.timout);
           let items = tours.map(tr => tr.then(tr => {
               if(tr.success) { //TODO
                   this.serverList.addItem(tr);
                   this.jsonList.removeItem(tr.id);
               } else{
                   this.jsonList.tagItem(tr.id);
               }
           }));
           Promise.all(items).then(() => {
               this.removeValidation();
           });
        })
        return btn;
    }

    renderTourList() {
        const tourList = new TourList().render();
        tourList.classList.add('tours-server');
        return tourList;
    }

    renderTours() {
        const tourList = document.createElement('div');
        tourList.classList.add('tours');
        tourList.appendChild(this.renderJsonTourList());
        tourList.appendChild(this.renderAddButton());
        tourList.appendChild(this.renderTourList());
        return tourList;
    }



    render() {
        const container = document.createElement('div');
        container.classList.add('container');
        container.appendChild(this.renderTours());
        return container;
    }
}

const root = document.getElementById("root");
const tourValidation = new TourValidation();
const tourPage = new TourPage(tourValidation);
root.appendChild(tourValidation.render())
root.appendChild(tourPage.render());

