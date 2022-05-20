
class ValidationNotification {
    container = null;
    navbarItemsEl = null;
    items = [];
    constructor() {
        let head = document.getElementsByTagName('HEAD')[0];
        let link = document.createElement('link');

        link.rel = 'stylesheet';
        link.type = 'text/css';
        link.href = '../../css/admin/validation-notification.css';

        head.appendChild(link);
    }

     renderStatusTxt() {
        const txt = document.createElement('div');
        txt.classList.add('status__txt');
        return txt;
    }
    renderTourStatus(tour) {
        const st = document.createElement('div');
        st.classList.add('tour__status');
        let statusTxt1 = this.renderStatusTxt();
        st.appendChild(statusTxt1);
        // this.startValidating(st);
        return st;
    }


    renderNavbarItems () {
        this.navbarItemsEl = document.createElement('div');
        this.navbarItemsEl.classList.add('navbar__items');
        return this.navbarItemsEl;
    }
    renderNavbar() {
        const navbar = document.createElement('div');
        const header = document.createElement('div');
        const hr = document.createElement('hr');
        navbar.classList.add('status__navbar');
        header.classList.add('navbar__header');
        header.textContent = "Validating Tours...";

        navbar.appendChild(header);
        navbar.appendChild(hr);
        navbar.appendChild(this.renderNavbarItems());
        return navbar;
    }

    addTour(tour) {
        this.container.classList.remove('hide');
        this.navbarItemsEl.appendChild(this.renderTourStatus(tour));
        this.items.push(tour.id);
    }
    setTourStatus(id, status, classList = []) {
        const index = this.items.findIndex(trId => trId == id);
        let item = this.navbarItemsEl.childNodes.item(index);
        let itemStatus = item.querySelector('.status__txt');
        itemStatus.textContent = status;
        for(const cls of classList) {
            item.classList.add(cls);
        }
    }
    removeTour(id) {

        const index = this.items.findIndex(trId => trId == id);
         this.navbarItemsEl.childNodes.item(index)?.remove();
         this.items.splice(index, 1);
         console.log('items ', this.items)
    }
    get container() {
        this.container;
    }

    render() {
        this.container =  document.createElement('div');
        this.container.classList.add('status__container');
        this.container.classList.add('hide');
        this.container.appendChild(this.renderNavbar());
        return this.container;
    }


}

export default ValidationNotification;