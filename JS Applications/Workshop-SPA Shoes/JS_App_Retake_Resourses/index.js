const userModel = firebase.auth();

const db = firebase.firestore();

const app = Sammy('#root', function() {

    this.use('Handlebars', 'hbs');


    // Get

    this.get('/home', function(context) {


        db.collection('offers')
            .get()
            .then((response) => {
                context.offers = response.docs.map((offer) => { return { id: offer.id, ...offer.data() } })
                extendContext(context)
                    .then(function() {
                        this.partial('./templates/home.hbs');
                    })
            })
            .catch(errorHandler);

    });

    this.get('/register', function(context) {
        extendContext(context)
            .then(function() {
                this.partial('./templates/register.hbs')
            });
    });

    this.get('/login', function(context) {
        extendContext(context)
            .then(function() {
                this.partial('./templates/login.hbs')
            });
    });

    this.get('/details/:offerId', function(context) {
        const { offerId } = context.params;

        db.collection('offers')
            .doc(offerId)
            .get()
            .then((response) => {

                const actualOfferData = response.data();
                const imTheSalesman = actualOfferData.salesman === getUserData().uid;

                const userIndex = actualOfferData.clients.indexOf(getUserData().uid);

                const imInTheClientsList = userIndex > -1;

                context.offer = {...actualOfferData, imTheSalesman, id: offerId, imInTheClientsList }
                extendContext(context)
                    .then(function() {
                        this.partial('./templates/detailsOffer.hbs')
                    })
            })


    });

    this.get('/create', function(context) {
        extendContext(context)
            .then(function() {
                this.partial('./templates/createOffer.hbs')
            })
    })

    // this.get('/edit-offer/:id', function(context) {
    //     extendContext(context)
    //         .then(function() {
    //             this.partial('./templates/editOffer.hbs')
    //         })
    // })

    this.get('/logout', function(context) {

        userModel.signOut()
            .then((response) => {
                clearUserData();
                this.redirect('/home');
            }).catch(errorHandler);


    })

    this.get('/delete/:offerId', function(context) {

        const { offerId } = context.params;

        db.collection('offers')
            .doc(offerId)
            .delete()
            .then(() => {
                this.redirect('#/home')
            })
            .catch(errorHandler);

    });

    this.get('/edit/:offerId', function(context) {
        const { offerId } = context.params;

        console.log(offerId);

        db.collection('offers')
            .doc(offerId)
            .get()
            .then((response) => {
                context.offer = { id: offerId, ...response.data() };
                console.log(response.data());
                extendContext(context)
                    .then(function() {
                        this.partial('./templates/editOffer.hbs')
                    })
            })



    })

    this.get('/buy/:offerId', function(context) {

        const { offerId } = context.params;
        const { uid } = getUserData();

        db.collection('offers')
            .doc(offerId)
            .get()
            .then((response) => {
                const offerData = {...response.data() };
                offerData.clients.push(uid)

                return db.collection('offers')
                    .doc(offerId)
                    .set(offerData)
            })
            .then(() => {
                this.redirect(`#/details/${offerId}`)
            })
            .catch(errorHandler);
    })


    // POST

    this.post('/edit/:offerId', function(context) {
        const { offerId, productName, price, description, brand, imageUrl } = context.params;


        db.collection('offers')
            .doc(offerId)
            .get()
            .then((response) => {
                return db.collection('offers')
                    .doc(offerId)
                    .set({
                        ...response.data(),
                        productName,
                        price,
                        brand,
                        description,
                        imageUrl
                    })
            })
            .then((response) => {
                this.redirect(`#/details/${offerId}`)
            })
            .catch(errorHandler);
    })

    this.post('/register', function(context) {
        const { email, password, rePassword } = context.params;

        if (password !== rePassword) {
            return;
        }

        userModel.createUserWithEmailAndPassword(email, password)
            .then((userData) => {
                this.redirect('#/login');
            })
            .catch(errorHandler);
    })

    this.post('/login', function(context) {
        const { email, password } = context.params;

        userModel.signInWithEmailAndPassword(email, password)
            .then((userData) => {
                saveUserData(userData);
                this.redirect('/home')
            }).catch(errorHandler);
    })

    this.post('/create', function(context) {

        const { productName, price, imageUrl, description, brand } = context.params;

        db.collection('offers').add({
                productName,
                price,
                imageUrl,
                description,
                brand,
                salesman: getUserData().uid,
                clients: []
            })
            .then((createdProduct) => {
                console.log(createdProduct);
                this.redirect('/home')
            })
            .catch(errorHandler);
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

function errorHandler(err) {
    console.log(err);
}

function saveUserData(data) {
    const { user: { email, uid } } = data;
    localStorage.setItem('user', JSON.stringify({ email, uid }));
}

function getUserData() {
    const user = localStorage.getItem('user')
    return user ? JSON.parse(user) : null
}

function clearUserData() {
    this.localStorage.removeItem('user');
}