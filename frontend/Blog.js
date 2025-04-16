let BlogsContainer = document.getElementById("BlogsContainer");

async function GetData() {
    let Res = await fetch("http://localhost:8080/api/Posts");
    Res = await Res.json();
    console.log(Res);
    DisplayData(Res);

}
GetData()

function DisplayData(data) {
  BlogsContainer.innerHTML = "";
  for (let i of data) {
    BlogsContainer.innerHTML += `
        <div class="BlogCard">
            <img src="https://wallpapercave.com/wp/wp2570196.jpg">
            <h2>${i.blogTitle}</h2>
            <h4>${i.blogDesc}</h4>
            <p>${i.blogAuthor}</p>
            <button>Read More</button>
        </div>
    `;
  }
}
