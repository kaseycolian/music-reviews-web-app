const commentBox = document.getElementById('newCommentForm');
commentBox
		.addEventListener('submit',
				function(event) {

					const commentDetailsInput = document
							.getElementById('leaveCommentBox').value;
					const userHandleInput = document
							.getElementById('userHandle').value;

					if (commentDetailsInput == "" || userHandleInput == "") {
						event.preventDefault();
						modalBox = document.getElementById('modalBox');

						// alert("Please enter a User Handle and Leave Comment
						// to submit a Comment");
						modalBox.style.display = "block"
						const modalCloseButton = document.getElementsByClassName("close")[0];
						modalCloseButton.addEventListener("click", function() {
							modalBox.style.display = "none";
						})
						return false;
					}

				})