import {getRequest} from "./api.js";


class TourItem {
    id = null;
    imgUrl = '';
    header = '';
    description = '';
    rating = null;
    price = null;

    constructor({id, imgUrl, header, description, rating = 0.0, price = 0.0}) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.header = header;
        this.description = description;
        this.rating = rating;
        this.price = price;
    }


    renderPhoto() {
        const photo = document.createElement('img');
        photo.classList.add('app-item__photo');
        photo.src = this.imgUrl;
        return photo;
    }
    renderContent() {
        const content = document.createElement('div');
        const header= document.createElement('div');
        const description= document.createElement('div');
        content.classList.add('app-item__content');
        header.classList.add('app-item__header');
        description.classList.add('app-item__description');
        content.appendChild(header);
        content.appendChild(description);
        header.textContent = this.header;
        description.textContent = this.description;
        return content;
    }
    renderReview() {
        const review = document.createElement('div');
        const rate = document.createElement('div');
        const priceWrapper= document.createElement('div');
        const price = document.createElement('div');
        priceWrapper.classList.add('app-item__price-wrapper');
        review.classList.add('app-item__review');
        rate.classList.add('app-item__rate');
        price.classList.add('app-item__price');
        review.appendChild(rate);
        priceWrapper.appendChild(price);
        review.appendChild(priceWrapper);

        rate.textContent = this.rating;
        price.textContent = this.price;
        return review;
    }
    renderBody() {
        const body = document.createElement('div');
        body.classList.add('app-item__body');
        body.appendChild(this.renderPhoto());
        body.appendChild(this.renderContent());
        body.appendChild(this.renderReview());
        return body;
    }


    render() {
        const item = document.createElement('div');
        item.classList.add('tour__item');
        item.appendChild(this.renderBody());
        return item;
    }
}






class AppTourList {
    container = null;
    tours = null;
    tourItems = {};
    newItemCounterEl= null;
    failedCounterEl= null;
    successCounter = 0;
    failCounter = 0;

    initTours() {
        getRequest('http://localhost:8080/app/rest/tour' , (items) => {
            for(let it of JSON.parse(items)) { //TODO
                const id = it.id;
                this.tourItems[id] = {...it, checked: false};
                this.addItem(it);
            }
        });
    }

     constructor() {}


    renderTourItem(item) {
        const itemWrapper = document.createElement('div');
        itemWrapper.classList.add('tour__wrapper');
        let itemEl = new TourItem({...item}).render();
        itemWrapper.appendChild(itemEl);
        return itemWrapper;
    }


    renderItems() {
        const items = Object.values(this.tourItems);
        this.tours = document.createElement('div');
        this.tours.classList.add('server-tours');
        items.forEach((it) => {
            this.tours.appendChild(this.renderTourItem(it));
        });
        return this.tours;
    }


    renderContainer() {
        const el  = document.createElement('div');
        el.id = 'server-list'
        el.classList.add('server-container');
        return el;
    }


    addNewItem(item) {
        this.tourItems[item.id] = {...item, checked: false};
        let newTour = this.renderTourItem(item);
        newTour.classList.add('border-green');
        this.tours.appendChild(newTour);
        // this.successCounter+=1;
        // this.newItemCounterEl.textContent = this.successCounter;
    }

    addItem(item) {
        this.tourItems[item.id] = {...item, checked: false};
        let newTour = this.renderTourItem(item);
        this.tours.appendChild(newTour);
    }
    countItem(success){
        if(success)
           this.newItemCounterEl.textContent = ++this.successCounter;
        else this.failedCounterEl.textContent = ++this.failCounter;
    }

    renderItemCounter() {
        const wrapper = document.createElement('div');
        this.newItemCounterEl = document.createElement('div');
        this.failedCounterEl = document.createElement('div');

        this.newItemCounterEl.textContent = this.successCounter;
        this.failedCounterEl.textContent = this.failCounter;

        wrapper.classList.add('counter__wrapper');
        this.newItemCounterEl.classList.add('header__counter');
        this.failedCounterEl.classList.add('header__counter-fail');

        wrapper.appendChild(this.newItemCounterEl);
        wrapper.appendChild(this.failedCounterEl);
        return wrapper;
    }

    renderHeader() {
        const header = document.createElement('div');
        const title = document.createElement('h2');
        title.textContent = 'App Tours';

        header.classList.add('header');
        title.classList.add('header__title');
        header.appendChild(title);
        header.appendChild(this.renderItemCounter());
        return header;
    }


    render() {
        this.container = this.renderContainer();
        const divider = document.createElement('hr');

        divider.classList.add('divider');
        this.container.classList.add('server-container');
        this.container.appendChild(this.renderHeader());
        this.container.appendChild(divider);
        this.container.appendChild(this.renderItems());
        return this.container;
    }}

export default AppTourList;


