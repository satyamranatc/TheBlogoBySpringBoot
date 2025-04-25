let BlogForm = document.getElementById("BlogForm");
let FormBtn = document.getElementById("FormBtn");
let BlogsContainer = document.getElementById("BlogsContainer");

let isUpdating = false;
let postId = null;

BlogForm.addEventListener("submit", async(e) => {
    e.preventDefault();
    let data = {
        blogPoster: e.target.blogPoster.value,
        blogTitle: e.target.blogTitle.value,
        blogDesc: e.target.blogDesc.value,
        blogAuthor: e.target.blogAuthor.value,
    }

    let Res = null;
    if (isUpdating) {
        Res = await axios.put(`http://localhost:8080/api/Posts/${postId}`, data);
        isUpdating = false;
        FormBtn.innerText = "Add Blog";
    } else {
        Res = await axios.post("http://localhost:8080/api/Posts", data);
    }
    
    if (Res.status == 200) {
        alert(Res.data);
        e.target.reset();
        GetData(); // Refresh the data after adding/updating
    } else {
        alert("Sorry Can't Add/Update the Post!");
    }
});

async function GetData() {
    try {
        let Res = await fetch("http://localhost:8080/api/Posts");
        Res = await Res.json();
        console.log(Res);
        DisplayData(Res);
    } catch (error) {
        console.error("Error fetching data:", error);
    }
}

GetData();

function DisplayData(data) {
    BlogsContainer.innerHTML = "";
    for (let i of data) {
        let row = document.createElement("tr");
        
        // Truncate description if too long
        let shortDesc = i.blogDesc.length > 100 ? i.blogDesc.substring(0, 100) + "..." : i.blogDesc;
        
        row.innerHTML = `
            <td>${i.blogTitle}</td>
            <td>${i.blogAuthor}</td>
            <td>${shortDesc}</td>
            <td class="action-btns">
                <button class="update-btn">Update</button>
                <button class="delete-btn">Delete</button>
            </td>
        `;
        
        // Add event listeners to buttons
        let updateBtn = row.querySelector(".update-btn");
        let deleteBtn = row.querySelector(".delete-btn");
        
        updateBtn.onclick = () => {
            postId = i.id;
            isUpdating = true;
            FormBtn.innerText = "Update Blog";
            
            // Populate form with existing data
            BlogForm.blogPoster.value = i.blogPoster;
            BlogForm.blogTitle.value = i.blogTitle;
            BlogForm.blogDesc.value = i.blogDesc;
            BlogForm.blogAuthor.value = i.blogAuthor;
            
            // Scroll to form
            BlogForm.scrollIntoView({ behavior: 'smooth' });
        };

        deleteBtn.onclick = async () => {
            if (confirm(`Are you sure you want to delete "${i.blogTitle}"?`)) {
                try {
                    let Res = await axios.delete(`http://localhost:8080/api/Posts/${i.id}`);
                    if (Res.status == 200) {
                        alert(Res.data);
                        GetData(); // Refresh the data after deleting
                    } else {
                        alert("Sorry Can't Delete the Post!");
                    }
                } catch (error) {
                    console.error("Error deleting post:", error);
                    alert("Error deleting post");
                }
            }
        };

        BlogsContainer.appendChild(row);
    }
}