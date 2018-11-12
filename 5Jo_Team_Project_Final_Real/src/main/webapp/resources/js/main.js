(function() {
	var support = {
		animations : Modernizr.cssanimations
	}, animEndEventNames = {
		'WebkitAnimation' : 'webkitAnimationEnd',
		'OAnimation' : 'oAnimationEnd',
		'msAnimation' : 'MSAnimationEnd',
		'animation' : 'animationend'
	}, animEndEventName = animEndEventNames[Modernizr.prefixed('animation')], onEndAnimation = function(
			el, callback) {
		var onEndCallbackFn = function(ev) {
			if (support.animations) {
				if (ev.target != this)
					return;
				this.removeEventListener(animEndEventName, onEndCallbackFn);
			}
			if (callback && typeof callback === 'function') {
				callback.call();
			}
		};
		if (support.animations) {
			el.addEventListener(animEndEventName, onEndCallbackFn);
		} else {
			onEndCallbackFn();
		}
	};

	var containers = [].slice.call(document.querySelectorAll('.container')), containersCount = containers.length, nav = document
			.querySelector('nav.thumb-nav'), pageTriggers = [].slice
			.call(nav.children), isAnimating = false, current = 0;

	function init() {
		resetScroll();
		// disable scrolling
		window.addEventListener('scroll', noscroll);
		// set current page trigger
		classie.add(pageTriggers[current], 'thumb-nav__item--current');
		// set current container
		classie.add(containers[current], 'container--current');
		// initialize events
		initEvents();
	}

	function initEvents() {
		// slideshow navigation
		pageTriggers.forEach(function(pageTrigger) {
			pageTrigger.addEventListener('click', function(ev) {
				ev.preventDefault();
				navigate(this);
			});
		});

		// open each container's content area when clicking on the respective
		// trigger button
		containers.forEach(function(container) {
			container.querySelector('button.trigger').addEventListener('click',	function() {
						toggleContent(container, this);
					});
		});
		
		// keyboard navigation events
		document
				.addEventListener(
						'keydown',
						function(ev) {
							var keyCode = ev.keyCode || ev.which, isContainerOpen = containers[current]
									.getAttribute('data-open') == 'open';

							switch (keyCode) {
							// left key
							case 37:
								if (current > 0 && !isContainerOpen) {
									navigate(pageTriggers[current - 1]);
								}
								break;
							// right key
							case 39:
								if (current < containersCount - 1
										&& !isContainerOpen) {
									navigate(pageTriggers[current + 1]);
								}
								break;
							}
						});
	}

	function navigate(pageTrigger) {
		var oldcurrent = current, newcurrent = pageTriggers
				.indexOf(pageTrigger);

		if (isAnimating || oldcurrent === newcurrent)
			return;
		isAnimating = true;

		// reset scroll
		allowScroll();
		resetScroll();
		preventScroll();

		var currentPageTrigger = pageTriggers[current], nextContainer = document
				.getElementById(pageTrigger.getAttribute('data-container')), currentContainer = containers[current], dir = newcurrent > oldcurrent ? 'left'
				: 'right';

		classie.remove(currentPageTrigger, 'thumb-nav__item--current');
		classie.add(pageTrigger, 'thumb-nav__item--current');

		// update current
		current = newcurrent;

		// add animation classes
		classie.add(nextContainer, dir === 'left' ? 'container--animInRight'
				: 'container--animInLeft');
		classie.add(currentContainer, dir === 'left' ? 'container--animOutLeft'
				: 'container--animOutRight');

		onEndAnimation(currentContainer, function() {
			// clear animation classes
			classie.remove(currentContainer,
					dir === 'left' ? 'container--animOutLeft'
							: 'container--animOutRight');
			classie.remove(nextContainer,
					dir === 'left' ? 'container--animInRight'
							: 'container--animInLeft');

			// clear current class / set current class
			classie.remove(currentContainer, 'container--current');
			classie.add(nextContainer, 'container--current');

			isAnimating = false;
		});
	}

	// show content section
	function toggleContent(container, trigger) {
		if (classie.has(container, 'container--open')) {
			classie.remove(container, 'container--open');
			classie.remove(trigger, 'trigger--active');
			classie.remove(nav, 'thumb-nav--hide');
			container.setAttribute('data-open', '');
			preventScroll();
		} else {
			classie.add(container, 'container--open');
			classie.add(trigger, 'trigger--active');
			classie.add(nav, 'thumb-nav--hide');
			container.setAttribute('data-open', 'open');
			allowScroll();
		}
	}

	// scroll functions
	function resetScroll() {
		document.body.scrollTop = document.documentElement.scrollTop = 0;
	}
	function preventScroll() {
		window.addEventListener('scroll', noscroll);
	}
	function allowScroll() {
		window.removeEventListener('scroll', noscroll);
	}
	function noscroll() {
		window.scrollTo(0, 0);
	}

	init();

	// For Demo purposes only (prevent jump on click)
	[].slice.call(document.querySelectorAll('.items-wrap a')).forEach(
			function(el) {
				el.onclick = function() {
					return false;
				}
			});
})();


$(function(){
			$('.home__btn').on('click',home);
})

function home(){
	location.href="./";
}