# Online 3
### Time: 25 minutes


You are tasked with creating a **notification** system for a banking platform that supports multiple
mediums such as *email*, *SMS*, and *mobile app notifications*. This system must allow customers to
**choose their preferred notification channel** for receiving alerts, such as *transaction updates*
(incoming/outgoing), *low balance warnings*, and *promotional offers*.

Customers should have the ***flexibility to switch their preferred notification channel dynamically***
without impacting the underlying logic that processes and dispatches these notifications. The
system should be designed with extensibility in mind, making it easy to integrate new channels,
such as WhatsApp, voice calls, or push notifications, without requiring changes to the existing
codebase.

Each notification channel *must handle its own specific formatting and sending logic
independently*, ensuring a clear separation of responsibilities. Despite the diversity of channels,
all notifications must maintain a consistent structure and content to provide a uniform experience
across dif