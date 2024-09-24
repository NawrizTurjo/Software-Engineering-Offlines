## CSE 214
## Online on Creational Pattern
**Time: 30 minutes**


You are developing a document editor that supports 3 types of file formats: *.docx*, *.pdf*,
and *.txt*. To handle each file type, you need different document processors. All
document processors implement an interface called DocumentProcessor, which
contains two methods - **LoadDocument** and **SaveDocument** (For now, these may just
print a message).

Given a file name, your system has to recognize the file type and use the appropriate
document processor to load and save a file. The output will be two messages showing
that the file was loaded and saved.