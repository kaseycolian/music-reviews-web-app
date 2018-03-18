const xhr = new XMLHttpRequest()

xhr.onreadystatechange = function() {
	if (xhr.readyState === 4 && xhr.status === 200) {

		const res = xhr.responseText;

		const tagList = document.getElementById('tagList');

		tagList.innerHTML = res;
		

	}
}
//creating ajax call to create new tag by method created in Controller
const form = document.getElementById('newTagForm');
form.addEventListener('submit', function(event) {
	event.preventDefault();
	const reviewTagId = document.getElementById('reviewTagId').value;
	const descriptionId = document.getElementById('descriptionId').value;
	xhr.open('POST', 'http://localhost:8080/add-tag', true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("reviewId=" + reviewTagId + "&tagDescription=" + descriptionId);

})
//creating ajax call to delete tag by method used created in Controller
const removeForm = document.getElementById('deleteTagForm');
removeForm.addEventListener('submit', function(event){
	event.preventDefault();
	const removeTagId = document.getElementById('removeTagId').value;
	const removeTagDescriptionId = document.getElementById('removeTagDescriptionId').value;
	xhr.open('POST', 'http://localhost:8080/remove-tag', true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("reviewId=" + removeTagId + "&tagDescription=" + removeTagDescriptionId);
	
})