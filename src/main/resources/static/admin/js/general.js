document.addEventListener('DOMContentLoaded', function () {
    let liElements = document.querySelectorAll('.menu li a');
    let liIndex =  sessionStorage.getItem("navIndex");

    if(liIndex != null) {
        liElements.forEach(el => el.parentElement.classList.remove('active'));
        liElements[liIndex].parentElement.classList.add('active');
    }
    
    liElements.forEach((element, index) => {
        element.addEventListener('click', function () {
            sessionStorage.setItem("navIndex", index);
        })
    });
    
    if (document.body.scrollHeight <= 1000) {
        const mainDiv = document.querySelector('.main');
        if(mainDiv) {
            mainDiv.style.marginBottom = "500px"; 
        }
    }

    const authToken = getCookieValue('idUser');
})

function getCookieValue(cookieName) {
    const cookies = document.cookie.split(';');
    for (let cookie of cookies) {
        cookie = cookie.trim();
        if (cookie.startsWith(cookieName + '=')) {
            return decodeURIComponent(cookie.substring(cookieName.length + 1));
        }
    }
    return null;
}