# Online on Creational Pattern

## Time: 30 minutes

You are developing a cross-platform game where the interface adapts based on the platform being used. The game needs to support both **Windows** and **MacOS** operating systems. Each platform has a unique style for UI components such as **Buttons** and **TextFields**. The system should allow new platforms (e.g., **Linux**) to be added without affecting the existing codebase.

You need to implement an abstract factory that produces platform-specific UI components. Each platform will have its own concrete factory that creates the appropriate Button and TextField.

Your task is to design the system so that adding new platforms and new UI components in the future requires minimal changes to the existing codebase.