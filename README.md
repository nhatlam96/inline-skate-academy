<a href="https://imgur.com/5MKRkEs">
    <img src="https://i.imgur.com/5MKRkEs.png" title="source: imgur.com" width="20%" />
</a>

# Inline Skate Academy 

For inline skaters, who need to learn on the go.  
Inline Skate Academy is an android mobile app for learning inline skating  
that supports categorized lessons with helpful videos and instructions.  
Unlike all competitors it can store user notes.

1. **App features**: inline skate learning content, local notes
2. **Market Proposition**: Market-Driven: Helpful videos to guide through the inline skating learning process with the ability to add notes. So users can see their notes for the lessons without having to switch to a notes app.

## Project Scope

### Functional Requirements

| Minimum requirements                      | Implementation                                                       |
|-------------------------------------------|----------------------------------------------------------------------|
| Multiple Screens                          | Multiple Activities, like Category X -> Lesson Y                     |
| RecyclerView                              | Category Activities displays an overview of lessons via RecyclerView |
| User input and storage                    | User can input notes and those will be saved locally                 |
| Offline functionality with local database | User notes are saved with Room                                       |
| Unit Tests                                | LessonTest, LessonNoteDAOTest and LessonNoteDatabaseTest             |

> This app does ***not support*** optional requirements (Responsive Layout, User Login with Firebase, Cloud Database, Crashlytics or Analytics, Background tasks, Animations, Multi-Language, Use of sensors or camera)

### User Stories

| Title       | ID  | Priority | Description                                                                      | Additional                                                                  |
|-------------|-----|----------|----------------------------------------------------------------------------------|-----------------------------------------------------------------------------|
| Home screen | HS  | Core     | A user can have an overview of all categories in the home screen **[DONE]**      | A user can also see how far their progress for the categories are **[WIP]** |
| Categories  | CTG | Core     | A user can explore the categories and get a list of it's lessons **[DONE]**      | A user can also see which have been marked as done **[WIP]**                |
| Lessons     | LSS | Core     | A user can find videos with instructions in the lessons and add notes **[DONE]** | User notes must be saved in a local database **[DONE]**                     |

### Time tracking

- Student: Nhat-Lam Luong
   - Matrikelnr.: 675523
   - email: inf3381@hs-worms.de

| Date     | Time (min) | TimeF(x) | Category      | Description             | User Story |
|----------|------------|----------|---------------|-------------------------|------------|
| 06.04.23 | 60         | 60       | Documentation | Define Idea             | -          |
| 12.04.23 | 30         | 90       | Home screen   | Basic Buttons           | HS         |
| 13.04.23 | 150        | 240      | Home screen   | Card views              | HS         |
| 16.04.23 | 60         | 300      | Misc          | Splashscreen + App Icon | -          |
| 17.04.23 | 30         | 330      | Misc          | Light- and dark theme   | -          |
| 17.05.23 | 180        | 510      | Categories    | RecyclerView            | CTG        |
| 17.07.23 | 300        | 810      | Lessons       | Novice Lessons          | LSS        |
| 21.07.23 | 30         | 840      | Lessons       | Regular Lessons         | LSS        |
| 22.07.23 | 30         | 870      | Lessons       | Expert Lessons          | LSS        |
| 04.08.23 | 90         | 960      | Lessons       | Theory Lessons          | LSS        |
| 05.08.23 | 420        | 1380     | Lessons       | Room Database           | LSS        |
| 06.08.23 | 220        | 1600     | Misc          | JUnit Tests             | -          |
| 07.08.23 | 60         | 1660     | Documentation | README.md               | -          |