const xhr = new XMLHttpRequest()

xhr.onreadystatechange = function() {
	if (xhr.readyState === 4 && xhr.status === 200) {
		const res = JSON.parse(xhr.responseText);
//		
//		if(res.length){
//			res.forEach(function(review){
//				appendOneElementToBody(review)
//			})
//		}else{
//			appendOneElementToBody(res)
//		}
//		})
		function appendNewTagToTagList(res){
		const tagAddButton = document.querySelector('#addTag');
		const tagToAdd = document.createElement('li');
		const tagParent = document.querySelector('ul');
		tagParent.appendChild(tagName);
		tagToAdd.innerHtml = res.tagDescription;
//		document.getElementsByName('ul').innerHTML=`<li>$(res.tagDescription}</li>`;
		
		
	}
}

xhr.open('GET', 'http://localhost:8080/review?id=1', true);
xhr.send();