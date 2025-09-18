// CREDITS:
// Flying Popup Generator
// by Urs Dudli and Peter Gehrig 
// Copyright (c) 2001 Peter Gehrig and Urs Dudli. All rights reserved.
// Permission given to use the script provided that this notice remains as is.
// Additional scripts can be found at http://www.24fun.com
// info@24fun.com
// 4/6/2001

// IMPORTANT: 
// If you add this script to a script-library or script-archive 
// you have to add a link to http://www.24fun.com on the webpage 
// where this script Script will be running.

// INSTRUCTIONS: 
// Got to http://www.24fun.com, open category 'utility' and
// generate your own Flying Popup with the new Flying Popup Generator

var popwindow
var thistoolbar
var thislocation
var thisdirectories
var thisstatus
var thismenubar
var thisscrollbars
var thisresizable
var thisurl
var thiswidth
var thisheight
var thisdirection
var thistopposition
var thisleftposition
var pause=20
var stepfactor=20
var stepx
var stepy

var marginpadding=23

var startleft=0
var endleft=0
var starttop=0
var endtop=0

var marginleft=0
var margintop=0
var marginright
var marginbottom
var timer

function openpopup() {

	thistoolbar=tistoolbar
	thislocation=tislocation
	thisdirectories=tisdirectories
	thisstatus=tisstatus
	thismenubar=tismenubar
	thisscrollbars=tisscrollbars
	thisresizable=tisresizable
	thisurl=tisurl
	thiswidth=tiswidth
	thisheight=tisheight
	thisdirection=tisdirection
	
	marginright=screen.width
	marginbottom=screen.height

	if (thisdirection=="horitop") {
		startleft=marginleft
		endleft=marginright-thiswidth-marginpadding
		starttop=marginpadding
		endtop=starttop
		stepx=stepfactor
		stepy=0	
	}
	if (thisdirection=="horimiddle") {
		startleft=marginleft
		endleft=marginright-thiswidth-marginpadding
		starttop=Math.round((marginbottom-thisheight)/2)
		endtop=starttop
		stepx=stepfactor
		stepy=0	
	}
	if (thisdirection=="horibottom") {
		startleft=marginleft
		endleft=marginright-thiswidth-marginpadding
		starttop=marginbottom-thisheight-2*marginpadding
		endtop=starttop
		stepx=stepfactor
		stepy=0	
	
	}
	if (thisdirection=="vertileft") {
		startleft=marginleft
		endleft=startleft
		starttop=marginpadding
		endtop=marginbottom-thisheight-2*marginpadding
		stepx=0
		stepy=stepfactor	
	}
	if (thisdirection=="vertimiddle") {
		startleft=Math.round((marginright-thiswidth)/2)
		endleft=startleft
		starttop=marginpadding
		endtop=marginbottom-thisheight-2*marginpadding
		stepx=0
		stepy=stepfactor	
	}
	if (thisdirection=="vertiright") {
		startleft=marginright-thiswidth-marginpadding
		endleft=marginright-thiswidth-marginpadding
		starttop=marginpadding
		endtop=marginbottom-thisheight-2*marginpadding
		stepx=0
		stepy=stepfactor	
	}
	popwindow=window.open(thisurl, "newwindow", "toolbar="+thistoolbar+",location="+thislocation+",directories="+thisdirectories+",status="+thisstatus+",menubar="+thismenubar+",scrollbars="+thisscrollbars+",resizable="+thisresizable+",width="+thiswidth+",height="+thisheight+",top="+starttop+",left="+startleft+"")
	movewindow()
	popwindow.focus()
}

function movewindow() {
	if ((starttop<=endtop) && (startleft<=endleft)){
		popwindow.moveTo(startleft,starttop)
		startleft+=stepx
		starttop+=stepy
		timer=setTimeout("movewindow()",pause)
	}
	else {
		clearTimeout(timer)
		popwindow.moveTo(endleft,endtop)
	}
}

window.onload=openpopup