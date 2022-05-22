// var xhr = new XMLHttpRequest();




export  const postRequest = (value, url) =>{
    let xhr = new XMLHttpRequest();
    xhr.open("POST", url, true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify({
        ...value
    }))
}

export  const getRequest = ( url, onReady = () => {}) =>{
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            onReady(xhr.responseText);
        }
    }
    xhr.open('GET', url, true);
    xhr.send(null);

}