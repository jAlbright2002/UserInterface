
function addCpu() {
    // Retrieve form data
    var name = document.getElementById("cpuName").value;
    var price = document.getElementById("cpuPrice").value;
    var socket = document.getElementById("cpuSocket").value;
    var frequency = document.getElementById("cpuFreq").value;
    var brand = document.getElementById("cpuBrand").value;
    var ebaylink = document.getElementById("ebayLink").value;
    // Retrieve other form fields as needed

    price = parseFloat(price);

    // Create a JavaScript object with the form data
    var cpuData = {
        name: name,
        price: price,
        socket: socket,
        frequency: frequency,
        brand: brand,
        ebaylink: ebaylink

        // Add other fields to the object
    };

    // Make an AJAX or Fetch request to the Java backend
    // Adjust the URL to match your backend endpoint
    fetch('/cpus', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(cpuData),
    })
        .then(response => response.json())
        .then(data => {
            console.log('Success:', data);
            // Handle success response if needed
        })
        .catch((error) => {
            console.error('Error:', error);
            // Handle error if needed
        });
}

var cpuContainer = document.getElementById('cpuContainer');

document.addEventListener('DOMContentLoaded', function() {
    // Your JavaScript code here
    updateCpuNames();
});

async function updateCpuNames() {
    try {
        // Introduce a delay of 500 milliseconds using a Promise and setTimeout
        await new Promise(resolve => setTimeout(resolve, 250));

        const response = await fetch('/cpus');
        const data = await response.json();

        // Assuming data is an array of CPU names
        displayCpuNames(data);
    } catch (error) {
        console.error('Error fetching CPU names:', error);
    }
}

function displayCpuNames(cpuNames) {
    // Assuming cpuContainer is a valid DOM element
    cpuContainer.innerHTML = ''; // Clear previous content

    // Iterate through the CPU names and append them to cpuContainer
    cpuNames.forEach(cpuName => {
        var p = document.createElement('p');
        p.textContent = cpuName;
        cpuContainer.appendChild(p);
    });
}

