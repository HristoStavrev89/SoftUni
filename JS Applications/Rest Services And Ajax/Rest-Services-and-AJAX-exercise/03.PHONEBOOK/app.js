function attachEvents() {
    const loadBtn = document.getElementById('btnLoad');
    const createBtn = document.getElementById('btnCreate');
    const loadDataUrl = `https://phonebook-nakov.firebaseio.com/phonebook.json`;

    let ul = document.getElementById('phonebook');

    loadBtn.addEventListener('click', () => {
        fetch(loadDataUrl)
            .then(response => response.json())
            .then((data) => {
                Object.keys(data).forEach((key) => {
                    let li = document.createElement('li');
                    li.textContent = `${data[key].person}: ${data[key].phone}`;

                    let deleteBtn = document.createElement('button');
                    deleteBtn.textContent = 'DELETE';


                    deleteBtn.addEventListener('click', () => deletePerson(key))

                    li.appendChild(deleteBtn);
                    ul.appendChild(li);
                });
            });
    })

    createBtn.addEventListener('click', create)

    function deletePerson(key) {
        let deleteUrl = `https://phonebook-nakov.firebaseio.com/phonebook/${key}.json`;
        fetch(deleteUrl, { method: "DELETE" });
    }

    function create() {
        let person = document.getElementById('person');
        let phone = document.getElementById('phone');
        fetch(loadDataUrl, { method: 'POST', body: JSON.stringify({ person: person.value, phone: phone.value }) })
    }
}

attachEvents();