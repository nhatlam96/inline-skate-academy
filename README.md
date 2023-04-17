# Project Scope
## User Stories
| Title      | ID  | Priority | Description                                                                                                                       | Additional                                                        |
| ---------- | --- | -------- | --------------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------- |
| Homescreen   | HS  | Core     | A user can have an overview of all lesson categories in the homescreen                                                              | A user can also see how far their progress for the categories are |
| Categories | CTG | Core     | A user can explore the categories and get a list of it's lessons                                                                  | A user can also see which have been marked as done                |
| Lessons    | LSS | Core     | A user can find pictures with instructions in the lessons and add or edit their notes for the lesson and also mark it as favorite | User notes must be saved in a local database                      |

## Time tracking
| Date     | Time (min) | TimeF(x) | Category     | Description                  | User Story |
| -------- | ---------- | -------- | ------------ |------------------------------| ---------- |
| 06.04.23 | 60         | 60       | Project Idea | Define Idea                  | -          |
| 12.04.23 | 30         | 90       | Homescreen   | Basic Buttons                | HS         |
| 13.04.23 | 150        | 240      | Homescreen   | Cardviews                    | HS         |
| 16.04.23 | 60         | 300      | Misc         | Splashscreen + App Icon      | -          |
| 17.04.23 | 30         | 330      | Misc         | Light- dark theme adjustment | -           |

## Project Idea
**Inline Skate Academy**
For inline skaters, who need to learn on the go.  
Inline Skate Academy is a mobile app for learning inline skating  
that supports various lessons with pictures and instructions.  
Unlike all competitors it can store user notes.
#### Refine Idea
1. **App features**: favorite list, notes, inline skate learning content
2. **Market Proposition**: Market-Driven: Instead of videos, there will be pictures with helpful descriptions and the user's own notes. So there is no need to watch whole time consuming videos and users can see their notes for the lessons without having to switch to a notes app.
3. **User Story**: "As a skater I would like an app which enables me to look up information quickly and learn efficiently for a trick or technique."
4. **Technical debts**: Everything, because I don't know anything about android development.
5. **Develop Vertical Prototype**: I don't know how to do that yet.
#### Minimum requirements
- Multiple screens: Category X -> Lesson 5
- User input and storage: User can input own notes and those will be saved locally
- RecyclerView (display a list or grid of objects)  
    - Homescreen displays different categories  
    - Categories displays different lessons
- Offline functionality with local database: User notes, lesson media (pictures, descriptions)
- Unit Tests: WIP
#### Optional requirements
- Responsive layout: Maybe
- User login (Firebase Auth): No
- Data synchronization with database in cloud: No
- Crashlytics or analytics: Maybe
- Background tasks: No
- Animations: Maybe
- Multi-Language support: Maybe
- Use of sensors or camera: No