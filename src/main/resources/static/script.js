const formEL = document.querySelector("form");
formEL.addEventListener("submit", async (e)=>{
    e.preventDefault();

    //console.log(formDataSerialized, "formDataSerialized");



    // try {
    //    const url ='https://hookbin.com/YV9eylzYM8fkdx7j60Jr'
    //    const response = await fetch(url, {
    //       mode: 'no-cors',
    //       method: 'POST',
    //       body: JSON.stringify(formDataSerialized),
    //       headers: {
    //          'Content-type' : 'application/json'
    //       },
    //    });


    // }catch(e) {
    //    console.error(e);
    //    alert('there was an error')

    // }

    let gender = "non-binary"

    if(document.getElementById('male').checked) {
        gender = "male";
    }else if(document.getElementById('female').checked) {
        gender = "female";
    }





    const name = document.getElementById("name").value;
    const email = document.getElementById("theemail").value;
    const address = document.getElementById("address").value;
    const streetNr = document.getElementById("streetNr").value;
    const zipCode = document.getElementById("zipCode").value;
    const phoneNr = document.getElementById("phoneNr").value;

    const obj = {
        name: name,
        email: email,
        gender: gender,
        address: address,
        streetNr: streetNr,
        zipCode: zipCode,
        phoneNr: phoneNr

    }
    let completeOject = true;

    for (const val of Object.values(obj)) {
        if (val === undefined || val === '') {
            completeOject = false;
            alert("Vennglist fyll alle feltene")
            break;
        }
    }

    if (completeOject){
        let xhr = new XMLHttpRequest();
        xhr.open("POST", "http://localhost:8080/api/ansatte");

        xhr.setRequestHeader("Accept", "application/json");
        xhr.setRequestHeader("Content-Type", "application/json");

        xhr.onload = () => console.log(xhr.responseText);





        const formData = new FormData(formEL);
        const formDataSerialized =Object.fromEntries(formData);
        const jSon = JSON.stringify(formDataSerialized);

        //console.log(jSon + " serialized" );



        for (const val of Object.values(obj)) {
            if (val === undefined || val === '') {
                alert(" Vennligst fyll alle feltene")
                break;
            }
        }

        const objSt = JSON.stringify(obj);

        isJsonString()

        function isJsonString(str) {
            try {
                JSON.parse(str);
                console.log(str);
                console.log("Its json")
            } catch (e) {
                return false;
            }
            return true;
        }
        isJsonString(objSt)


        //console.log(objSt + " new Json Object")






        let data = `{
    
   "name" : "Hufdy",
   "email" : "samagmail.com",
   "gender": "male",
   "address": "Sfokf",
   "streetNr": "15D",
    "zipCode": "1551",
    "phoneNr": "915484"
    
    }`;



        xhr.onreadystatechange = function (){
            if(xhr.readyState ===4){
                if(xhr.status === 200){
                    alert("Ny person har registerert")
                }
                if(xhr.status === 500){
                    alert("Denne epost er allerde registrert")
                }
                if(xhr.status === 400){
                    alert("Et av feltene har feil verdi")
                }
            }

        }

        console.log(data + " real")
        xhr.send(objSt);

    }






});