# giphyApi
Sample app that loads Giphy images from Rest API

I've used MVP as presentation pattern, with a Repository that decouples the networking from the UI.

There is a bug with the size of the ImageView after it's recycled, but I couldn't get what's going on.

And there is a sample project in the Glide Library Repo that uses a preload feature: https://github.com/bumptech/glide/blob/master/samples/giphy/src/main/java/com/bumptech/glide/samples/giphy/MainActivity.java
