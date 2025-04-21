let BlogContainer = document.getElementById("BlogContainer");

function getIdFromUrl() {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get('id');
  }

async function GetData() {
    const id = getIdFromUrl();
    let Res = await fetch(`http://localhost:8080/api/Posts/${id}`);
    Res = await Res.json();
    console.log(Res);
    DisplayData(Res);

}
GetData()

function DisplayData(data) {
  BlogContainer.innerHTML = "";
    BlogContainer.innerHTML += `
        <div class="BlogCard">
            <img src="${data.blogPoster}">
            <h2>${data.blogTitle}</h2>
            <h4>${data.blogDesc}</h4>
            <p>${data.blogAuthor}</p>
        </div>
    `;
}
