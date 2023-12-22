function addPart() {
    var partName = document.getElementById('partName').value;

    // Check if partName is not empty
    if (partName.trim() !== '') {
        var partContainer = document.getElementById('partContainer');

        // Create a new div element
        var newPartDiv = document.createElement('div');

        // Set the content of the new div
        newPartDiv.innerHTML = partName;

        // Optionally, you can add additional HTML structure or styling to newPartDiv

        // Append the new div to the partContainer
        partContainer.appendChild(newPartDiv);

        // Clear the input field
        document.getElementById('partName').value = '';
    }
}

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
