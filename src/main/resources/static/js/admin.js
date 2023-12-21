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
