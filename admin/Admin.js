let BlogForm = document.getElementById("BlogForm");

BlogForm.addEventListener("submit", async(e) => {
    e.preventDefault();
    let data = {
        blogTitle: e.target[0].value,
        blogDesc: e.target[1].value,
        blogAuthor: e.target[2].value,
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