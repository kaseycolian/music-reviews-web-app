const h1 = document.querySelector('header');
h1.addEventListener('mouseenter', function() {
	h1.innerHTML = '<em>Welcome!</em>';
	h1.style.fontSize = '4.5rem';
	h1.style.color = 'lightgrey';
	// h1.style.backgroundImage=('url(/images/stars.png)');
})

h1.addEventListener('mouseout', function() {
	h1.innerText = 'Music Reviews by Genres';
	// h1.style.backgroundImage=('none');
})

const listItems = document.querySelectorAll('ul li');
listItems.forEach(function(listItem) {
	listItem.addEventListener('mouseout', function() {
		this.style.fontSize = '2.5rem';
	})
})

const backgroundSection = document.querySelector('.container')
const genresTitle = document.querySelector('h2')
genresTitle.addEventListener('click', function() {

	backgroundSection.style.backgroundImage = ('url(/images/music.png)');
	backgroundSection.style.backgroundSize = 'cover';
	backgroundSection.style.backgroundRepeat = 'repeat';
	backgroundSection.style.backgroundColor = 'rgba(0, 0, 0, 0.65)';
	// backgroundSection.style.backgroundColor = 'rgba(232, 9, 180, 0.15)'
})
genresTitle.addEventListener('dblclick', function() {
	backgroundSection.style.backgroundImage =  ('none');
	backgroundSection.style.backgroundColor = 'rgba(0, 0, 0, 0.00)';
})
