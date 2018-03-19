const xhr = new XMLHttpRequest()

xhr.onreadystatechange = function() {
	if (xhr.readyState === 4 && xhr.status === 200) {

		const res = xhr.responseText;

		const tagList = document.getElementById('tagList');

		tagList.innerHTML = res;

	}
}

function clearField() {

	document.newTagForm.reset();

}

// need this const form for creating tag method - don't delete
const form = document.getElementById('newTagForm');

// creating ajax call to create new tag by method created in Controller
form.addEventListener('submit', function(event) {
	// stops from automatically adding in order to check for exceptions
	event.preventDefault();

	//opens tag modal box if tag field is empty upon submission.
	const tagInputBox = document.getElementById('descriptionId').value;
	if (tagInputBox == "") {
		modalBox = document.getElementById('tagModalBox');
		modalBox.style.display = "block"
		const modalCloseButton = document.getElementsByClassName("close")[1];
		modalCloseButton.addEventListener("click", function() {
			modalBox.style.display = "none";
		})
		return false;
	}

	const reviewTagId = document.getElementById('reviewTagId').value;
	const descriptionId = document.getElementById('descriptionId').value;

	xhr.open('POST', 'http://localhost:8080/add-tag', true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("reviewId=" + reviewTagId + "&tagDescription=" + descriptionId);

	// resets form to original placeholder text
	newTagForm.reset();

})

// const newTagFiller = document.getElementById('descriptionId');
// newTagFiller.style.placeholder="this";

// creating ajax call to delete tag by method used created in Controller
const removeForm = document.getElementById('deleteTagForm');
removeForm.addEventListener('submit',
		function(event) {
			event.preventDefault();

			const tagDeleteBox = document
					.getElementById('removeTagDescriptionId').value;
			if (tagDeleteBox == "") {
				// event.preventDefault();
				modalBox = document.getElementById('tagModalBox');
				modalBox.style.display = "block"
				const modalCloseButton = document.getElementsByClassName("close")[1];
				modalCloseButton.addEventListener("click", function() {
					modalBox.style.display = "none";
				})

				return false;
			}

			const removeTagId = document.getElementById('removeTagId').value;
			const removeTagDescriptionId = document
					.getElementById('removeTagDescriptionId').value;

			xhr.open('POST', 'http://localhost:8080/remove-tag', true);
			xhr.setRequestHeader("Content-type",
					"application/x-www-form-urlencoded");
			xhr.send("reviewId=" + removeTagId + "&tagDescription="
					+ removeTagDescriptionId);
			removeForm.reset();

		})
