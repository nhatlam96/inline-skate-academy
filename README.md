# Project Scope

## User Stories

| Title       | ID  | Priority | Description                                                           | Additional                                                        |
|-------------|-----|----------|-----------------------------------------------------------------------|-------------------------------------------------------------------|
| Home screen | HS  | Core     | A user can have an overview of all categories in the home screen      | A user can also see how far their progress for the categories are |
| Categories  | CTG | Core     | A user can explore the categories and get a list of it's lessons      | A user can also see which have been marked as done                |
| Lessons     | LSS | Core     | A user can find videos with instructions in the lessons and add notes | User notes must be saved in a local database                      |

## Time tracking

- Student: Nhat-Lam Luong

| Date     | Time (min) | TimeF(x) | Category     | Description                  | User Story |
|----------|------------|----------|--------------|------------------------------|------------|
| 06.04.23 | 60         | 60       | Project Idea | Define Idea                  | -          |
| 12.04.23 | 30         | 90       | Home screen  | Basic Buttons                | HS         |
| 13.04.23 | 150        | 240      | Home screen  | Card views                   | HS         |
| 16.04.23 | 60         | 300      | Misc         | Splashscreen + App Icon      | -          |
| 17.04.23 | 30         | 330      | Misc         | Light- dark theme adjustment | -          |
| 17.05.23 | 180        | 510      | Categories   | RecyclerView                 | CTG        |
| 17.07.23 | 300        | 810      | Lessons      | Novice Lessons               | LSS        |
| 21.07.23 | 30         | 840      | Lessons      | Regular Lessons              | LSS        |
| 22.07.23 | 30         | 870      | Lessons      | Expert Lessons               | LSS        |
| 04.08.23 | 90         | 960      | Lessons      | Theory Lessons               | LSS        |
| 05.08.23 | 300        | 1260     | Lessons      | Room Database implementation | LSS        |

## Project Idea

**Inline Skate Academy**
For inline skaters, who need to learn on the go.  
Inline Skate Academy is a mobile app for learning inline skating  
that supports various lessons with videos and instructions.  
Unlike all competitors it can store user notes.

#### Refine Idea

1. **App features**: inline skate learning content, notes
2. **Market Proposition**: Market-Driven: Helpful videos to guide through the inline skating
   learning process with the ability to add notes. So users can see their notes for the lessons
   without having to switch to a notes app.

#### Minimum requirements

- Multiple screens: Category X -> Lesson 5
- User input and storage: User can input own notes and those will be saved locally
- RecyclerView (display a list or grid of objects)  - Categories displays different lessons
- Offline functionality with local database: User notes, lesson descriptions
- Unit Tests: WIP

#### Optional requirements

- Responsive layout: No
- User login (Firebase Auth): No
- Data synchronization with database in cloud: No
- Crashlytics or analytics: No
- Background tasks: No
- Animations: No
- Multi-Language support: No
- Use of sensors or camera: No