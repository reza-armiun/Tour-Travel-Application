import {MOCK_ITEMS} from "./mock-list.js";

const omitKey = (key, { [key]: _, ...obj }) => obj

class JsonItem {
    id = null;
    imgUrl = '';
    name = '';
    description = '';
    rating = null;
    price = null;
    rest;

    constructor({id, imgUrl, name, description, rating = 0.0, price = 0.0, ...rest}) {
        this.id = id;
        this.imgUrl = imgUrl;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.price = price;
        this.rest = omitKey('checked', rest);
    }


    renderPhoto() {
        const photo = document.createElement('img');
        photo.classList.add('item__photo');
        photo.src = this.imgUrl;
        return photo;
    }
    renderContent() {
        const content = document.createElement('div');
        const header= document.createElement('div');
        const description= document.createElement('div');
        content.classList.add('item__content');
        header.classList.add('item__header');
        description.classList.add('item__description');
        content.appendChild(header);
        content.appendChild(description);

        header.textContent = this.name;
        description.textContent = this.description;
        return content;
    }
    renderReview() {
        const review = document.createElement('div');
        const rate = document.createElement('div');
        const price = document.createElement('div');
        review.classList.add('item__review');
        rate.classList.add('item__rate');
        price.classList.add('item__price');
        review.appendChild(rate);
        review.appendChild(price);

        rate.textContent = this.rating;
        price.textContent = this.price;
        return review;
    }
    renderBody() {
        const body = document.createElement('div');
        body.classList.add('item__body');
        body.appendChild(this.renderPhoto());
        body.appendChild(this.renderContent());
        body.appendChild(this.renderReview());
        return body;
    }

    renderDetails() {
        const wrapper = document.createElement('div');
        wrapper.classList.add('item__expand-wrapper');
        wrapper.classList.add('hide');
        const details = document.createElement('pre');
        details.classList.add('item__expand');
        details.classList.add('hide');
        const obj = {id : this.id , imgUrl: this.imgUrl, header: this.name, description: this.rating, rating: this.rating, price: this.price, ...this.rest};
        details.innerHTML = JSON.stringify(obj , undefined, 4)
        details.addEventListener('click', function (ev) {
            ev.stopPropagation();
        });
        wrapper.appendChild(details);

        return details;
    }

    renderFooter() {
        const footer = document.createElement('div');
        const expandArrow = document.createElement('i');
        const  details = this.renderDetails();
        footer.classList.add('item__footer');
        expandArrow.classList.add('item__expand-arrow');
        expandArrow.addEventListener('click' ,  (ev) => {
            ev.stopPropagation();
            this.showDetails(details);
        });
        footer.appendChild(expandArrow);
        footer.appendChild(details);
        return footer;
    }

    showDetails(node) {
        node.classList.toggle('hide');
        node.classList.toggle('show-animation');
    }





    render() {
        const item = document.createElement('div');
        item.classList.add('tour-json__item');
        item.appendChild(this.renderBody());
        item.appendChild(this.renderFooter());
        return item;
    }
}


 class JsonTourList{
     container = null;
     toursEl = null;
     tourItems = {};
     disabledNodes = {};


    constructor() {
        for(let it of MOCK_ITEMS) { //TODO
            const id = it.id;
            this.tourItems[id] = {...it, checked: false};
        }
    }


    renderTourItem(item) {
        const itemWrapper = document.createElement('div');
        const checkbox = this.renderCheckbox(item.checked, item.id );
        itemWrapper.classList.add('tour-json__wrapper');
        let itemEl = new JsonItem({...item}).render();
        itemWrapper.appendChild(itemEl);
        itemWrapper.appendChild(checkbox);
         itemWrapper.addEventListener('click',(e) => this.onClickItemHandler( item.id));
        return itemWrapper;
    }
    onClickItemHandler( id) {
        this.tourItems[id] = {...this.tourItems[id], checked: !this.tourItems[id].checked};
        this.toggleCheckbox(id);
    }

     renderCheckbox(checked, id) {
         const cb = document.createElement('input');
         cb.type = 'checkbox';
         cb.classList.add('tour__checkbox');
         cb.checked = checked;
         cb.addEventListener('click' ,  (ev) => {
             ev.stopPropagation();
             this.tourItems[id] = {...this.tourItems[id], checked: !this.tourItems[id].checked};
         })
         return cb;
     }

     renderItems() {
         const items = Object.values(this.tourItems);
         const tours = document.createElement('div');
         tours.classList.add('tours-json');
         items.forEach((it ) => {
             tours.appendChild(this.renderTourItem(it));
         });
         return tours;
     }


     toggleCheckbox(id) {
         let index = Object.keys(this.tourItems).findIndex(tourId => tourId == id);
         let tour = this.container.lastChild.childNodes.item(index);
         let cb =tour.querySelector('input');
         cb.checked = !cb.checked;
     }

     renderContainer() {
         const el  = document.createElement('div');
         el.id = 'json-list'
         el.classList.add('json-container');
         return el;
     }


     get checkItems() {
        return Object.values(this.tourItems).filter(it => it.checked);
     }
     removeItem(id) {
         let domIndex = Object.keys(this.tourItems).findIndex(tourId => tourId == id);
         this.toursEl.childNodes.item(domIndex).remove();
         const newList = {...this.tourItems};
         delete newList[id];
         this.tourItems = {...newList};
     }

     setFailMode(id) {
         let domIndex = Object.keys(this.tourItems).findIndex(tourId => tourId == id);
         let item = this.toursEl.childNodes.item(domIndex);
         item.classList.add('border-orange');
     }

     disableItem(id) {
         let domIndex = Object.keys(this.tourItems).findIndex(tourId => tourId == id);
         let item = this.toursEl.childNodes.item(domIndex);
         this.disabledNodes[id] = item;
         item.classList.add('disable');
         item.replaceWith(item.cloneNode(true));
     }
     enableItem(id) {
         let domIndex = Object.keys(this.tourItems).findIndex(tourId => tourId == id);
         let item = this.toursEl.childNodes.item(domIndex);
         this.disabledNodes[id].classList.remove('disable');
         item.replaceWith(this.disabledNodes[id]);
         delete this.disabledNodes[id];
     }



     render() {
         this.container = this.renderContainer();
         const header =document.createElement('h2');
         header.textContent = 'Json Tours';
         this.container.appendChild(header);
         this.toursEl = this.renderItems();
         this.container.appendChild(this.toursEl);
         return this.container;
     }
 }


export default JsonTourList;