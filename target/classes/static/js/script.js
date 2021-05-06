var clicked;
function popup(event){
    // console.log(event.target.id)



    switch (event.target.id) {
        case "avatar":
            select_avatar();
            break;
        case 'name':
            change_name()
            break;
        // case 'password':

        //   break;
        default:
            document.getElementById('popupinfo').innerHTML = event.target.id;
    }

    var popup = document.getElementById("popup");
    popup.style.visibility = "visible";
}



function hide_popup(decidion){
    var popup = document.getElementById("popup");
    popup.style.visibility = "hidden";

    if(decidion){
        let avas = document.getElementsByName("current-ava");


        for(const e of avas){
            console.log("current scr: "+e.src);
            console.log(clicked.src)
            e.src=clicked.src;
        }
        //console.log(avas.src)
        //document.getElementsByName("current-ava").src=clicked.src;
    }
}


function select_avatar(){

    let popupinfi_block = document.getElementById('popupinfo');

    popupinfi_block.innerHTML = '<div class="popup-avatar-change">'+
        '<img class="popup-avatar-change-img" src="../../img/046-woman.png" alt="#">'+
        '<img class="popup-avatar-change-img" src="../../img/001-man.png" alt="#">'+
        '<img class="popup-avatar-change-img" src="../../img/002-man.png" alt="#">'+
        '<img class="popup-avatar-change-img" src="../../img/004-man.png" alt="#">'+
        '<img class="popup-avatar-change-img" src="../../img/008-man.png" alt="#">'+

        '<img class="popup-avatar-change-img" src="../../img/009-man.png" alt="#">'+
        '<img class="popup-avatar-change-img" src="../../img/013-woman.png" alt="#">'+
        '<img class="popup-avatar-change-img" src="../../img/014-woman.png" alt="#">'+
        '<img class="popup-avatar-change-img" src="../../img/048-woman.png" alt="#">'+
        '<img class="popup-avatar-change-img" src="../../img/016-woman.png" alt="#">'+
        '</div>';



    document.addEventListener('click', function (e) {

        if(e.target.className =="popup-avatar-change-img"){

            if(!clicked){
                clicked = e.target;
                clicked.style.background = "rgba(0, 0, 0, 0.671)"//black
            } else{
                clicked.style.background = "rgba(255, 255, 255, 0.671)"//white
                clicked = e.target;
                clicked.style.background = "rgba(0, 0, 0, 0.671)"
            }
        }
    })

}


function change_name(){

}