
import Swal from "sweetalert2";

let myLastVersionOfObject={};
let file= null;
let secondFile=null;
let imgUrl=null;
function loadObject(){
    
    fetch('http://localhost:8080/MalaiKa/Admin/v1/header/findById/'+1,{
        method:'GET',
        headers: {
            'Content-Type': 'application/json'
        },
    }).then(response=>{
        if(!response.ok){
            Swal.fire({
                position: "top-end",
                icon: "error",
                title: "erreur lors de l'operation",
                showConfirmButton: false,
                timer: 1500,
              });
        }
        return response.json();
    }).then(data=>{ 
        myLastVersionOfObject=data;
        console.log(myLastVersionOfObject);
    });

}

function saveHeaderLocalisation(){
    const location= document.getElementById('localisation').value;
    const MyHeaderComponentLocation={
        id:1,
        localisation:location,
        email:myLastVersionOfObject.email,
        telephone:myLastVersionOfObject.telephone,
        logoImage:myLastVersionOfObject.logoImage,
        nomSite:myLastVersionOfObject.nomSite,
        menuUn:myLastVersionOfObject.menuUn,
        menuDeux:myLastVersionOfObject.menuDeux,
        menuTrois:myLastVersionOfObject.menuTrois,
        menuQuatre:myLastVersionOfObject.menuQuatre,
        menuCinq:myLastVersionOfObject.menuCinq
    }
    save(MyHeaderComponentLocation);
}

function save(object){
    fetch('http://localhost:8080/MalaiKa/Admin/v1/header/create',{
        method:'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body:JSON.stringify(object)
    }).then(response=>{
        if(!response.ok){
            Swal.fire({
                position: "top-end",
                icon: "error",
                title: "erreur lors de l'ajout",
                showConfirmButton: false,
                timer: 1500,
                width:'300px'
              });
        }else{
            Swal.fire({
                position: "top-end",
                icon: "success",
                title: "valeur ajouté avec succès!",
                showConfirmButton: false,
                timer: 1500,
                width:'300px'
              });
        }
    });
}

function saveHeaderTelephone(){
    const tel= document.getElementById('telephone').value;
    
    const MyHeaderComponentLocation={
        id:1,
        localisation:myLastVersionOfObject.localisation,
        email:myLastVersionOfObject.email,
        telephone:tel,
        logoImage:myLastVersionOfObject.logoImage,
        nomSite:myLastVersionOfObject.nomSite,
        menuUn:myLastVersionOfObject.menuUn,
        menuDeux:myLastVersionOfObject.menuDeux,
        menuTrois:myLastVersionOfObject.menuTrois,
        menuQuatre:myLastVersionOfObject.menuQuatre,
        menuCinq:myLastVersionOfObject.menuCinq
    }

    save(MyHeaderComponentLocation)
}

function saveHeaderEmail(){
    const emailValue=document.getElementById('mail').value;
    const MyHeaderComponentLocation={
        id:1,
        localisation:myLastVersionOfObject.localisation,
        email:emailValue,
        telephone:myLastVersionOfObject.telephone,
        logoImage:myLastVersionOfObject.logoImage,
        nomSite:myLastVersionOfObject.nomSite,
        menuUn:myLastVersionOfObject.menuUn,
        menuDeux:myLastVersionOfObject.menuDeux,
        menuTrois:myLastVersionOfObject.menuTrois,
        menuQuatre:myLastVersionOfObject.menuQuatre,
        menuCinq:myLastVersionOfObject.menuCinq
    }
    save(MyHeaderComponentLocation);
}

function saveHeaderNomSite(){
    const nomSite=document.getElementById('nom').value;
    const MyHeaderComponentLocation={
        id:1,
        localisation:myLastVersionOfObject.localisation,
        email:myLastVersionOfObject.email,
        telephone:myLastVersionOfObject.telephone,
        logoImage:myLastVersionOfObject.logoImage,
        nomSite:nomSite,
        menuUn:myLastVersionOfObject.menuUn,
        menuDeux:myLastVersionOfObject.menuDeux,
        menuTrois:myLastVersionOfObject.menuTrois,
        menuQuatre:myLastVersionOfObject.menuQuatre,
        menuCinq:myLastVersionOfObject.menuCinq
    }
    save(MyHeaderComponentLocation);
}

function onFileInput(event) {
    const fileInput = event.target;
    if (fileInput.files && fileInput.files.length > 0) {
      file = fileInput.files[0];
      console.log(file)
      const fileReader = new FileReader();
      fileReader.readAsDataURL(file);
      fileReader.onload = (event) => {
        if (fileReader.result) {
          imgUrl = fileReader.result;
        }
      };
    }
}

function onFileInputForSecondImage(event) {
    const fileInput = event.target;
    if (fileInput.files && fileInput.files.length > 0) {
      secondFile = fileInput.files[0];
      console.log(secondFile)
      const fileReader = new FileReader();
      fileReader.readAsDataURL(file);
      fileReader.onload = (event) => {
        if (fileReader.result) {
          imgUrl = fileReader.result;
        }
      };
    }
}


function savePhoto(idHeader, titre,file,context) {
    if (idHeader && titre && file) {
        const formData = new FormData();
        formData.append('file', file);
      fetch(`http://localhost:8080/MalaiKa/Admin/v1/photo/savePhoto/${idHeader}/${titre}/`+context, {
        method: 'POST',
       
        body: formData
      }).then(response => {
        if(!response.ok){
            Swal.fire({
                position: "top-end",
                icon: "error",
                title: "erreur lors de l'ajout",
                showConfirmButton: false,
                timer: 1500,
                width:'300px'
              });
        }else{
            Swal.fire({
                position: "top-end",
                icon: "success",
                title: "valeur ajouté avec succès!",
                showConfirmButton: false,
                timer: 1500,
                width:'300px'
              });
        }
      }).catch(error => {
        console.error('Erreur lors de la requête:', error);
      });
    }
}

function saveFirstMenuItem(){
    const premierMenuValue= document.getElementById('Menu_1_nom').value;
    const MyHeaderComponentLocation={
        id:1,
        localisation:myLastVersionOfObject.localisation,
        email:myLastVersionOfObject.email,
        telephone:myLastVersionOfObject.telephone,
        logoImage:myLastVersionOfObject.logoImage,
        nomSite:myLastVersionOfObject.nomSite,
        menuUn:premierMenuValue,
        menuDeux:myLastVersionOfObject.menuDeux,
        menuTrois:myLastVersionOfObject.menuTrois,
        menuQuatre:myLastVersionOfObject.menuQuatre,
        menuCinq:myLastVersionOfObject.menuCinq
    }
    save(MyHeaderComponentLocation);
}

function saveSecondMenuItem(){
    const deuxiemeMenuValue= document.getElementById('Menu_2_nom').value;
    const MyHeaderComponentLocation={
        id:1,
        localisation:myLastVersionOfObject.localisation,
        email:myLastVersionOfObject.email,
        telephone:myLastVersionOfObject.telephone,
        logoImage:myLastVersionOfObject.logoImage,
        nomSite:myLastVersionOfObject.nomSite,
        menuUn:myLastVersionOfObject.menuUn,
        menuDeux:deuxiemeMenuValue,
        menuTrois:myLastVersionOfObject.menuTrois,
        menuQuatre:myLastVersionOfObject.menuQuatre,
        menuCinq:myLastVersionOfObject.menuCinq
    }
    save(MyHeaderComponentLocation)
}

function saveThirdMenuItem(){
    const troisiemeMenuValue=document.getElementById('Menu_3_nom').value;
    console.log(troisiemeMenuValue)
    const MyHeaderComponentLocation={
        id:1,
        localisation:myLastVersionOfObject.localisation,
        email:myLastVersionOfObject.email,
        telephone:myLastVersionOfObject.telephone,
        logoImage:myLastVersionOfObject.logoImage,
        nomSite:myLastVersionOfObject.nomSite,
        menuUn:myLastVersionOfObject.menuUn,
        menuDeux:myLastVersionOfObject.menuDeux,
        menuTrois:troisiemeMenuValue,
        menuQuatre:myLastVersionOfObject.menuQuatre,
        menuCinq:myLastVersionOfObject.menuCinq
    }
    save(MyHeaderComponentLocation)
}

function saveFourthMenuItem(){
    const quatriemeMenuValue= document.getElementById('Menu_4_nom').value;
    const MyHeaderComponentLocation={
        id:1,
        localisation:myLastVersionOfObject.localisation,
        email:myLastVersionOfObject.email,
        telephone:myLastVersionOfObject.telephone,
        logoImage:myLastVersionOfObject.logoImage,
        nomSite:myLastVersionOfObject.nomSite,
        menuUn:myLastVersionOfObject.menuUn,
        menuDeux:myLastVersionOfObject.menuDeux,
        menuTrois:myLastVersionOfObject.menuTrois,
        menuQuatre:quatriemeMenuValue,
        menuCinq:myLastVersionOfObject.menuCinq
    }
    save(MyHeaderComponentLocation);
}
function saveFithMenuItem(){
    const cinquiemeMenuValue=document.getElementById('Menu_5_nom').value;
    const MyHeaderComponentLocation={
        id:1,
        localisation:myLastVersionOfObject.localisation,
        email:myLastVersionOfObject.email,
        telephone:myLastVersionOfObject.telephone,
        logoImage:myLastVersionOfObject.logoImage,
        nomSite:myLastVersionOfObject.nomSite,
        menuUn:myLastVersionOfObject.menuUn,
        menuDeux:myLastVersionOfObject.menuDeux,
        menuTrois:myLastVersionOfObject.menuTrois,
        menuQuatre:myLastVersionOfObject.menuQuatre,
        menuCinq:cinquiemeMenuValue
    }
    save(MyHeaderComponentLocation)
}

let myImage=null;

async function imageObjectSave(image) {
    try {
        const response = await fetch('http://localhost:8080/MalaiKa/Admin/v1/SliderImage/create', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(image)
        });

        if (!response.ok) {
            Swal.fire({
                position: "top-end",
                icon: "error",
                title: "erreur lors de l'ajout",
                showConfirmButton: false,
                timer: 1500,
            });
        } else {
            const data = await response.json();
            return data;
        }
    } catch (error) {
        console.error('Erreur lors de la requête:', error);
    }
}
async function saveImage(){
    const ImageObject={
        imagePath:""
    }
    myImage=await imageObjectSave(ImageObject);
    console.log(myImage)
    if (myImage && myImage.id) {
        savePhoto(myImage.id, 'imageSliderImage', file, 'imageSlider');
    } else {
        console.error('Erreur: myImage ou myImage.id est indéfini');
    }

}

function saveLikeHibernateSaveMethod(objectName,body){
    fetch('http://localhost:8080/MalaiKa/Admin/v1/'+objectName+'/create',{
        method:'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body:JSON.stringify(body)
    }).then(response=>{
        if(!response.ok){
            Swal.fire({
                position: "top-end",
                icon: "error",
                title: "erreur lors de l'ajout",
                showConfirmButton: false,
                timer: 1500,
                width:'300px'
              });
        }else{
            Swal.fire({
                position: "top-end",
                icon: "success",
                title: "objet ajouté avec succès!",
                showConfirmButton: false,
                timer: 1500,
                width:'300px'
              });
        }
    });
}

function saveBouttonText(){
    const bouttonTextValue= document.getElementById('boutton_text').value;
    const SliderBouttonObj={
        value: bouttonTextValue
    }
    saveLikeHibernateSaveMethod("SliderButton",SliderBouttonObj);
}
async function saveLikeHibernateSaveMethodWithAsync(objectName,body){
    try {
        const response = await fetch('http://localhost:8080/MalaiKa/Admin/v1/'+objectName+'/create', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(body)
        });

        if (!response.ok) {
            Swal.fire({
                position: "top-end",
                icon: "error",
                title: "erreur lors de l'ajout",
                showConfirmButton: false,
                timer: 1500,
            });
        } else {
            const data = await response.json();
            return data;
        }
    } catch (error) {
        console.error('Erreur lors de la requête:', error);
    }
}

async function saveOurService(){
    const title= document.getElementById('title').value;
    const contenuSection= document.getElementById('contenu').value;
    const sectionName=document.getElementById('ourServicesName').value;
    const descriptionSection=document.getElementById('descriptionSection').value;

    const objet={
        nomSection: sectionName,
        titre:title,
        contenu:contenuSection,
        description:descriptionSection,
        imagePath:""
    }
    const myOurService= await saveLikeHibernateSaveMethodWithAsync("OurService",objet);
    console.log(myOurService);
    if(myOurService && myOurService.id){
        savePhoto(myOurService.id,'OurServicePhotCard',file,"ourService")
    }
}
let Realisationcollection=[]
let Objectcollection=[]
async function findAll(objectName) {
    try {
        const response = await fetch('http://localhost:8080/MalaiKa/Admin/v1/'+objectName+'/all'); // Remplacez par l'URL réelle
        if (!response.ok) {
            throw new Error('Failed to fetch data');
        }
        Objectcollection = await response.json();
        updateDropdown();
    } catch (error) {
        console.error('Error fetching data:', error);
    }
}
async function findAllRealisation(objectName) {
    try {
        const response = await fetch('http://localhost:8080/MalaiKa/Admin/v1/'+objectName+'/all');
        if (!response.ok) {
            throw new Error('Failed to fetch data');
        }
        Realisationcollection = await response.json();
        updateDropdownRealisation();
    } catch (error) {
        console.error('Error fetching data:', error);
    }
}
function updateDropdown(){
    const selectDropdown= document.getElementById('options');
    selectDropdown.innerHTML='';
    Objectcollection.forEach(ourService=>{
        const option=document.createElement('option');
        option.value=ourService.id;
        option.textContent=ourService.nomSection+" "+ourService.titre;
        selectDropdown.appendChild(option);
    });

}


async function savePhotoAsync(idHeader, titre, file, context) {
    if (idHeader && titre && file) {
      const formData = new FormData();
      formData.append('file', file);
      const response = await fetch(`http://localhost:8080/MalaiKa/Admin/v1/photo/savePhoto/${idHeader}/${titre}/${context}`, {
        method: 'POST',
        body: formData
      });
  
      if (!response.ok) {
        Swal.fire({
          position: "top-end",
          icon: "error",
          title: "erreur lors de l'ajout",
          showConfirmButton: false,
          timer: 1500,
          width: '300px'
        });
      } else {
        Swal.fire({
          position: "top-end",
          icon: "success",
          title: "valeur ajouté avec succès!",
          showConfirmButton: false,
          timer: 1500,
          width: '300px'
        });
      }
    }
  }
async function saveWhoWeAre(){
    const resumeOh= document.getElementById('resume').value;
    const contenuOh= document.getElementById('contenuWhoWeAre').value;
    const ulFirstElement=document.getElementById('firstUlListElement').value;
    const ulSecondElement=document.getElementById('secondUlListElement').value;
    const ulThirdElement=document.getElementById('thirdUlListElement').value;

    const whoweare={
        id:4,
        resume:resumeOh,
        contenu:contenuOh,
        image:"",
        imageArrondi:"",
        premierElement:ulFirstElement,
        secondElement:ulSecondElement,
        troisiemeElement:ulThirdElement
    }
    const myWhoWeAre=await saveLikeHibernateSaveMethodWithAsync("WhoWeAre",whoweare);
    console.log(myWhoWeAre);
    if(myWhoWeAre && myWhoWeAre){
        await savePhotoAsync(myWhoWeAre.id,'OurWhoWeArePhotoCard',file,"whoweareImageCard");
        await savePhotoAsync(myWhoWeAre.id,'OurWhoWeArePhotoArrondi',secondFile,"whoweareImageArrondi");
    }
}

function updateDropdownRealisation(){
    const selectDropdown= document.getElementById('optionsRealisation');
    selectDropdown.innerHTML='';
    console.log("realisations "+Objectcollection);
    Realisationcollection.forEach(realisation=>{
        const option=document.createElement('option');
        option.value=realisation.id;
        option.textContent=realisation.nomSection+" "+realisation.titre;
        selectDropdown.appendChild(option);
    });
}

async function saveRealisation(){
    const title=document.getElementById('titleCard').value;
    const contentCard=document.getElementById('contenuCard').value;
    const nomSection=document.getElementById('ourServicesNm').value;
    const descriptionSectionNH=document.getElementById('descriptionTitleSectionH').value;
    const descriptionSection=document.getElementById('descriptionSectionHB').value;

    const Realisation={
        titre:title,
        contenu:contentCard,
        nomSection:nomSection,
        imagePath:"",
        descriptionTitre:descriptionSectionNH,
        descriptionSection:descriptionSection
    }
    const myRealisation= await saveLikeHibernateSaveMethodWithAsync("Realisation",Realisation);
    if(myRealisation && myRealisation.id){
        await savePhotoAsync(myRealisation.id,'OurWhoWeArePhotoCard',file,"realisation");
    }
}

function saveFooterService(){
    const firstElement=document.getElementById('firstUlListElementT').value;
    const secondElement=document.getElementById('secondUlListElementT').value;
    const thirdElement=document.getElementById('thirdUlListElementT').value;
    const fourthElement=document.getElementById('fourthUlListElementT').value;
    const fithElement=document.getElementById('fiththUlListElementT').value;
    const sixElement=document.getElementById('sixUlListElementT').value
    const ServiceInfo={
        id:1,
        premierMenu:firstElement,
        deuxiemeMenu:secondElement,
        troisiemeMenu:thirdElement,
        quatriemeMenu:fourthElement,
        cinquimeMenu:fithElement,
        sixiemeMenu:sixElement,
    }
    saveLikeHibernateSaveMethod("ServiceInfo",ServiceInfo);
}

window.addEventListener('load',loadObject);
window.addEventListener('load',()=> findAll("OurService"));
document.getElementById('telephoneClick').addEventListener('click',saveHeaderTelephone);
document.getElementById('locationClick').addEventListener('click',saveHeaderLocalisation);
document.getElementById('mailAdding').addEventListener('click', saveHeaderEmail);
document.getElementById('siteNameButton').addEventListener('click',saveHeaderNomSite);
document.getElementById('fileInput').addEventListener('change',onFileInput);
document.getElementById('savePhoto').addEventListener('click',() => savePhoto(1, 'logoSite', file))
document.getElementById('menuUnValue').addEventListener('click', saveFirstMenuItem)
document.getElementById('menuDeuxSave').addEventListener('click',saveSecondMenuItem)
document.getElementById('menuTroisSave').addEventListener('click',saveThirdMenuItem)
document.getElementById('menuQuatreSave').addEventListener('click',saveFourthMenuItem)
document.getElementById('menuCinqSave').addEventListener('click',saveFithMenuItem)
document.getElementById('images').addEventListener('change',onFileInput);
document.getElementById('imageCollectionsButton').addEventListener('click',saveImage)
document.getElementById('boutton_textSave').addEventListener('click',saveBouttonText)
document.getElementById('imagesOurService').addEventListener('change',onFileInput)
document.getElementById('saveSectionInfo').addEventListener('click',saveOurService)
document.getElementById('images1').addEventListener('change',onFileInput)
document.getElementById('images2').addEventListener('change',onFileInputForSecondImage)
document.getElementById('saveWhoWeAre').addEventListener('click',saveWhoWeAre)
window.addEventListener('load',()=> findAllRealisation("Realisation"));
document.getElementById('imagesSVG').addEventListener('change',onFileInput)
document.getElementById('saveRealisation').addEventListener('click',saveRealisation)
document.getElementById('saveFooterServiceId').addEventListener('click',saveFooterService)