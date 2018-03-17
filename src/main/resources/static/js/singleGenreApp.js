const h1 = document.querySelector('header');
h1.addEventListener('mouseover', function() {
	h1.innerHTML = '<em>Pick An Artist To Get Reviews</em>';
	h1.style.fontSize = '3.5rem';
	h1.style.color = '#CBD534';
	// h1.style.backgroundImage=('url(/images/stars.png)');
})
//add Ajax to this function to get res.category.id
h1.addEventListener('mouseout', function() {
					h1.innerHTML = 'reviews ';
})

const bandTiles = document.querySelectorAll('ul li');
const bandImages = document.querySelectorAll('ul li img');
bandImages.forEach(function(listItem) {
	listItem.addEventListener('mouseover', function() {
		listItem.style.transition = '2s';
	})
	listItem.addEventListener('mouseout', function() {
		listItem.style.transition = '1.4s';
	})
	listItem.addEventListener('mouseover', function() {
		listItem.style.boxShadow = '.6rem .6rem .6rem #1A242E';
	})
	listItem.addEventListener('mouseout', function() {
		listItem.style.boxShadow = '.02rem .01rem .1rem gold';
	})

})

// //HTML Canvas for moving backgrounds!

// Try to make a new line transition below header that says to pick an artist to
// review
// var header = document.querySelector('header');
// newHeaderLine = document
// .createElement('p')
//
// newHeaderLine.innerHTML = '<br></br><p> This a new thing </p>';
// newHeaderLine.style.fontSize = '3rem';
// newHeaderLine.style.color = 'white';
//
// header.appendChild(newHeaderLine);
