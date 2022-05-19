

const STATUS = {
    LOADING: 'Loading...',
    FINISHED: 'Completed',
    FAILED: 'Failed'
};
function getRandomNumber() {
    return Math.random().toFixed(1) * 10000;
}

class TourValidation {
    container = null;
    tours = [];
    constructor() {
        let head = document.getElementsByTagName('HEAD')[0];
        let link = document.createElement('link');

        link.rel = 'stylesheet';
        link.type = 'text/css';
        link.href = '../../css/admin/tour-validation-status-bar.css';

        head.appendChild(link);
    }

     async validateTour(st) {
         let text = st.firstChild;
         return new Promise((resolve, reject) => {
             text.textContent = 'Loading';
             st.classList.add('tour__status-loading');
            const num = getRandomNumber();
            setTimeout(() => {
                resolve(num);
            }, num );
        }).then( () => {
            let ran = getRandomNumber() / 1000;
            const isValid =  ran > 5 ;
             text.textContent = isValid ? STATUS.FINISHED : STATUS.FAILED;
             st.classList.add(isValid ? 'tour__status-success' : 'tour__status-failed');
             setTimeout(() => {
                 let parentNode = st.parentNode;
                 parentNode.removeChild(st);
             }, 2000);
             return isValid;
        }) ;
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
        const navbarItems = document.createElement('div');
        navbarItems.classList.add('navbar__items');
        return navbarItems;
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


    addTours(tours) {
        let navbarItems = this.container.querySelector('.navbar__items');
        this.container.classList.remove('hide');
        // render tour status


        return tours.map(tour => {
            let st = navbarItems.appendChild(this.renderTourStatus());
            return this.validateTour(st).then(isValid  => {
                if(isValid) {
                    tour.success = true;
                    return tour;
                }
                return  tour;
            })
        });
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

export default TourValidation;