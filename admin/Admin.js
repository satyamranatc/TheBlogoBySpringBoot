let BlogForm = document.getElementById("BlogForm");
let BlogsContainer = document.getElementById("BlogsContainer");

BlogForm.addEventListener("submit", async(e) => {
    e.preventDefault();
    let data = {
        blogPoster: e.target[0].value,
        blogTitle: e.target[1].value,
        blogDesc: e.target[2].value,
        blogAuthor: e.target[3].value,
    }

    let Res = await axios.post("http://localhost:8080/api/Posts",data)
    if (Res.status == 200)
    {
        alert(Res.data)
        e.target.reset();
    }
    else
    {
        alert("Sorry Cant Add the Post!")
    }
        
});




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

    let BlogCard = document.createElement("div");
    BlogCard.classList.add("BlogCard")

        BlogCard.innerHTML = `
            <h2>${i.blogTitle}</h2>
            <p>${i.blogAuthor}</p>
        `

        let UpdBtn = document.createElement("button");
        let DltBtn = document.createElement("button");

        UpdBtn.innerText = "Update Data"
        DltBtn.innerText = "Delete Data"

        UpdBtn.onclick = ()=>{
            alert("Update")
            
        }

        DltBtn.onclick = async ()=>{
            let id = i.id;
            let Res = await axios.delete(`http://localhost:8080/api/Posts/${id}`)
            if (Res.status == 200)
            {
                alert(Res.data)
                e.target.reset();
            }
            else
            {
                alert("Sorry Cant Add the Post!")
            }
           
        }

        BlogCard.append(UpdBtn);
        BlogCard.append(DltBtn);
    BlogsContainer.append(BlogCard);

  }
}
