const url = "http://localhost:8080/task/user/2"; // Corrigido 'localhots' para 'localhost'

function hideloader() {
   document.getElementById("loading").style.display = "none"; // Corrigido a vírgula por ponto
}

function show(tasks) {
    let tab = `
        <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Description</th>
                <th scope="col">Username</th>
                <th scope="col">UserId</th>
            </tr>
        </thead>
    `;

    for (let task of tasks) {
        tab += `
            <tr>
                <td scope="row">${task.id}</td>
                <td>${task.description}</td>
                <td>${task.user.login}</td>
                <td>${task.user.id}</td>
            </tr>
        `;
    }

    document.getElementById("task").innerHTML = tab;
}

async function getAPI(url) {
    const response = await fetch(url, { method: "GET" });

    // Corrigido dois pontos para ponto e vírgula
    const data = await response.json();

    if (response.ok) {
        hideloader();
        show(data);
    } else {
        console.error("Erro na requisição", response.status);
    }
}

// Executa a requisição
getAPI(url);
