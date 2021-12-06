# Android Clean Architecture
A clean architecture example. Using Kotlin Flow, Retrofit and Dagger Hilt, etc.

### Intro
Architecture means the overall design of the project. It's the organization of the code into classes or files or components or modules. And it's how all these groups of code relate to each other. The architecture defines where the application performs its core functionality and how that functionality interacts with things like the database and the user interface.

Clean architecture refers to organizing the project so that it's easy to understand and easy to change as the project grows. This doesn't happen by chance. It takes intentional planning.

## Clean Architecture

![alt text](https://github.com/QasimNawaz/CleanArchDemo/blob/main/images/clean_arch.png?raw=true)

### Layers
There are three layers in this app.

| Presentation Layer  | Domain Layer  | Data Layer |
| :---------------: | :---------------: | :---------------: |
| your ui/view | entity | data source, dto |
| your viewmodel | usecase | repository implementation |
| probably your extension | repository interface | your library config(retrofit/room) |
| etc... | etc... | etc... |
