class TourItem {
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
        photo.classList.add('app-item__photo');
        photo.src = this.img;
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
        const price = document.createElement('div');
        review.classList.add('app-item__review');
        rate.classList.add('app-item__rate');
        price.classList.add('app-item__price');
        review.appendChild(rate);
        review.appendChild(price);

        rate.textContent = this.rate;
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
const ITEMS =[{
    id: 1,
    img: 'https://th.bing.com/th/id/OIP.YPTa9g7VLfC2rRjD4VQrMAHaE8?pid=ImgDet&rs=1',
    header: 'Tour 1',
    description: 'Tour Description',
    rate: 8.1,
    price: 25.6
},{
    id: 2,
    img: 'https://th.bing.com/th/id/OIP.YPTa9g7VLfC2rRjD4VQrMAHaE8?pid=ImgDet&rs=1',
    header: 'Tour 2',
    description: 'Tour Description',
    rate: 8.1,
    price: 25.6
},{
    id: 3,
    img: 'https://th.bing.com/th/id/OIP.YPTa9g7VLfC2rRjD4VQrMAHaE8?pid=ImgDet&rs=1',
    header: 'Tour 3',
    description: 'Tour Description',
    rate: 8.1,
    price: 25.6
}];





class AppTourList {
    container = null;
    tours = null;
    tourItems = {};

     constructor() {
         let head = document.getElementsByTagName('HEAD')[0];
         let link = document.createElement('link');

         link.rel = 'stylesheet';
         link.type = 'text/css';
         link.href = '../../css/admin/app-tour-list.css';

         head.appendChild(link);

         for(let it of ITEMS) { //TODO
             const id = it.id;
             this.tourItems[id] = {...it, checked: false};
         }
     }


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
        items.forEach((it ,index) => {
            this.tours.appendChild(this.renderTourItem(it, index));
        });
        return this.tours;
    }


    renderContainer() {
        const el  = document.createElement('div');
        el.id = 'server-list'
        el.classList.add('server-container');
        return el;
    }


    addItem(item) {
        this.tourItems[item.id] = {...item, checked: false};
        const tours = document.querySelector('.server-tours');
        let newTour = this.renderTourItem(item);
        newTour.classList.add('border-green');
        tours.appendChild(newTour);

    }


     render() {
         this.container = this.renderContainer();
         const header = document.createElement('h2');
         const divider = document.createElement('hr');
         header.textContent = 'App Tours';
         header.classList.add('header');
         divider.classList.add('divider');
         this.container.classList.add('server-container');
         this.container.appendChild(header);
         this.container.appendChild(divider);
         this.container.appendChild(this.renderItems());
         return this.container;
    }
}

export default AppTourList;


