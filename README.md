# Data Tool

Data Tool aims to function as a utility library allowing developers to easily read and write data to files.


# How to use

Download the latest jar here <TODO: Add link>

Import the jar and make a reference to the main class like so:
`DataTool dt = new DataTool("filename");`
This is a Data Tool object and in order to reference the correct file it must have a valid path that exists. If the folders that you specify are not there it will not create/reference the file.

An example of writing a String to file:
`dt.writeString(key, data);`
This will write to the file in a key:data format. The parameters are strings in correspondence with the method name.

An example of data retrieval:
`dt.getString(key);`
