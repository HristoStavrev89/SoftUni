const app = Sammy('#container', function() {

    this.use('Handlebars', 'hbs');


    this.get('/home', function(context) {


        firebase
            .firestore()
            .collection('movies')
            .get()
            .then((response) => {

                context.movies = response.docs.map((movie) => { return { id: movie.id, ...movie.data() } })

                extendContext(context)
                    .then(function() {
                        this.partial('./templates/homeUser.hbs')
                    })
            })
            .catch(errorhandler);

    });

    // Movies routers

    this.get('/add-movie', function(context) {

        extendContext(context)
            .then(function() {
                this.partial('./templates/addMovie.hbs')
            })
    });

    this.get('/description-movie/:movieId', function(context) {

        const { movieId } = context.params;

        firebase
            .firestore()
            .collection('movies')
            .doc(movieId)
            .get()
            .then((response) => {

                const peopleLikedNumber = response.data().peopleLiked.length

                const actualMovieData = response.data();
                const imTheCreator = actualMovieData.creator === getUserData().uid;

                const userIndex = actualMovieData.peopleLiked.indexOf(getUserData().uid);

                const iLikedTheMovie = userIndex > -1;

                context.movie = {...actualMovieData, imTheCreator, id: movieId, iLikedTheMovie, peopleLikedNumber }

                extendContext(context)
                    .then(function() {
                        this.partial('./templates/descriptionMovie.hbs')
                    })
            })

    });

    this.get('/edit-movie', function(context) {

        extendContext(context)
            .then(function() {
                this.partial('./templates/editMovie.hbs')
            })
    });

    this.post('/add-movie', function(context) {
        const { title, imageUrl, description } = context.params;

        firebase
            .firestore()
            .collection('movies')
            .add({
                title,
                imageUrl,
                description,
                creator: getUserData().uid,
                peopleLiked: []
            })
            .then((addedMovie) => {
                console.log(addedMovie);
                this.redirect('/home')
            })
            .catch(errorhandler);
    })

    this.get('/like/:movieId', function(context) {

            const { movieId } = context.params;
            const { uid } = getUserData();

            firebase
                .firestore()
                .collection('movies')
                .doc(movieId)
                .get()
                .then((response) => {
                    const movieData = {...response.data() };
                    movieData.peopleLiked.push(uid);

                    return firebase
                        .firestore()
                        .collection('movies')
                        .doc(movieId)
                        .set(movieData)
                })
                .then(() => {
                    this.redirect(`#/description-movie/${movieId}`)
                })
                .catch(errorhandler)
        })
        // User routers

    this.get('/login', function(context) {

        extendContext(context)
            .then(function() {
                this.partial('./templates/loginUser.hbs')
            })
    });

    this.post('/login', function(context) {
        const { email, password } = context.params;

        firebase.auth().signInWithEmailAndPassword(email, password)
            .then((userData) => {
                saveUserData(userData);
                this.redirect('/home')
            }).catch(errorHandler);
    })

    this.get('/logout', function(context) {
        firebase.auth().signOut()
            .then((response) => {
                clearUserData();
                this.redirect('/home');
            }).catch(errorHandler);
    })

    this.get('/register', function(context) {

        extendContext(context)
            .then(function() {
                this.partial('./templates/registerUser.hbs')
            })
    });

    this.post('/register', function(context) {
        const { email, password, repeatPassword } = context.params;

        if (password !== repeatPassword) {
            //todo notification for the successfully registered user
            return;
        }
        firebase.auth().createUserWithEmailAndPassword(email, password)
            .then((response) => {
                this.redirect('#/login')
            })
            .catch(errorhandler);
    })





});


(() => {
    app.run('/home')
})();

function extendContext(context) {
    const user = getUserData();
    context.isLoggedIn = Boolean(user);
    context.userEmail = user ? user.email : '';
    return context.loadPartials({
        'header': './partials/header.hbs',
        'footer': './partials/footer.hbs'
    })
}

function getUserData() {
    const user = localStorage.getItem('user')
    return user ? JSON.parse(user) : null
}


function errorhandler(error) {
    console.log(error);
}

function saveUserData(data) {
    const { user: { email, uid } } = data;
    localStorage.setItem('user', JSON.stringify({ email, uid }));
}

function clearUserData() {
    this.localStorage.removeItem('user');
}