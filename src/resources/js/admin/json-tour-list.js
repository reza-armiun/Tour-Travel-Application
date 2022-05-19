
class JsonItem {
    id = null;
    img = '';
    header = '';
    description = '';
    rate = null;
    price = null;

    constructor({id, img, header, description, rate = 0.0, price = 0.0}) {
        this.id = id;
        this.img = img;
        this.header = header;
        this.description = description;
        this.rate = rate;
        this.price = price;
    }


    renderPhoto() {
        const photo = document.createElement('img');
        photo.classList.add('item__photo');
        photo.src = this.img;
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

        header.textContent = this.header;
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

        rate.textContent = this.rate;
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

    showDetails(node) {
        node.classList.toggle('hide');
    }

    renderFooter() {
        const footer = document.createElement('div');
        const expandArrow = document.createElement('i');
        const details = document.createElement('pre');
        footer.classList.add('item__footer');
        expandArrow.classList.add('item__expand-arrow');
        details.classList.add('item__expand');
        details.classList.add('hide');
        const obj = {id : this.id , img: this.img, header: this.header, description: this.rate, rate: this.rate, price: this.price};
        details.innerHTML = JSON.stringify(obj , undefined, 4)
        expandArrow.addEventListener('click' ,  (ev) => {
            ev.stopPropagation();
            this.showDetails(details);
        });
        details.addEventListener('click', function (ev) {
            ev.stopPropagation();
        });
        footer.appendChild(expandArrow);
        footer.appendChild(details);
        return footer;
    }

    render() {
        const item = document.createElement('div');
        item.classList.add('tour-json__item');
        item.appendChild(this.renderBody());
        item.appendChild(this.renderFooter());
        return item;
    }
}

const ITEMS =[{
    id: 4,
    img: 'https://th.bing.com/th/id/OIP.YPTa9g7VLfC2rRjD4VQrMAHaE8?pid=ImgDet&rs=1',
    header: 'Custom Tour 1',
    description: 'Tour Description',
    rate: 8.1,
    price: 25.6
},{
    id: 5,
    img: 'https://th.bing.com/th/id/OIP.dHJ2e7OgXAVpbj38MxihIAHaE8?pid=ImgDet&rs=1',
    header: 'Custom Tour 2',
    description: 'Tour Description',
    rate: 8.1,
    price: 25.6
},{
    id: 6,
    img: 'https://th.bing.com/th/id/OIP.haDqsmP5az2jk01FXuTPowHaE8?pid=ImgDet&rs=1',
    header: 'Custom Tour 3',
    description: 'Tour Description',
    rate: 8.1,
    price: 25.6
},{
    id: 7,
    img: 'data:image/jpeg;base64,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',
    header: 'Custom Tour 3',
    description: 'Tour Description',
    rate: 8.1,
    price: 25.6
},
    {
        id:8,
        img: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTB0RDfqBTVQUiL2PZ3t22wGjfOnVp9GnbxmQ&usqp=CAU',
        header: 'Custom Tour 3',
        description: 'Tour Description',
        rate: 8.1,
        price: 25.6
    },


];


 class JsonTourList{
     container = null;
     toursEl = null;
     tourItems = {};


    constructor() {
        let head = document.getElementsByTagName('HEAD')[0];
        let link = document.createElement('link');

        link.rel = 'stylesheet';
        link.type = 'text/css';
        link.href = '../../css/admin/json-tour-list.css';

        head.appendChild(link);
        for(let it of ITEMS) { //TODO
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
         el.classList.add('container');
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

     tagItem(id) {
         let domIndex = Object.keys(this.tourItems).findIndex(tourId => tourId == id);
         let item = this.toursEl.childNodes.item(domIndex);
         item.classList.add('border-orange');
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