$('#fizzbuzz-form').submit(function(e){
    e.preventDefault();
    const url=$(this).closest('form').attr('action'),
    data=$(this).closest('form').serialize();
    $.ajax({
        url:url,
        type:'get',
        data:data,
        success:function(data){
        fillResult(data);
       }
   });
});

function fillResult(data) {
    const resultContainer = document.getElementById('result-container');
    const list = document.getElementById('result-list');
    removeChildren(list);
    if (data.length > 0) {
        resultContainer.style.visibility = 'visible';
        for (item of data) {
            addListElement(list, item);   
        }
    } else {
        resultContainer.style.visibility = "hidden";
    }
}

function addListElement(list, innerHTML) {
    const liElement = document.createElement('li');
    liElement.innerHTML = innerHTML;
    liElement.classList.add("list-group-item");
    liElement.classList.add("text-center");
    liElement.classList.add("flex-fill");
    list.appendChild(liElement);
}

function removeChildren(element) {
    while (element.firstChild) {
        element.removeChild(element.lastChild);
      }
}