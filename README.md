# sLib  

How to use:  

Make jar (be sure to exclude the test package)  


This is a simple graphics library, primarily for personal use, but anyone is free to use it however they like.
Main pieces of this library are the SFrame, Display, and Layer classes. The SFrame will house your implementation of
Display, its buffered draw routine, and skips the repetitive parts of a JFrame. Create a subclass of Display
and put all timer-related code inside the onTick method.
A display will have layers, which you add by instantiating a Layer class and calling addLayer(Layer), and each layer has
their own pixel buffer (ex: render sky on first layer, then actual game environment on second layer, and then HUD on third).
Each pixel buffer is pushed to the active Display every time the internal update method is called (which also calls the
updateBuffer method.  

Todo:  
Circles

Issues:  
allows layers to be added more than once < add check  
layers start off null, if they aren't modified to begin with it causes nullpointer 
