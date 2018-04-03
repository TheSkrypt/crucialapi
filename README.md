# Crucial API
![SonarQube Tech Debt](https://img.shields.io/sonar/https/ccq.skrypt.net/crucialapi/tech_debt.svg)
[![SonarQube Coverage](https://img.shields.io/sonar/http/ccq.skrypt.net/crucialapi/coverage.svg)](https://ccq.skrypt.net/dashboard?id=crucialapi)

Note - this is a continuation of the SkryptCoreAPI. It was renamed to a more suitable name, as the API is not intented for use by my plugins **only** anymore.

Most APIs are / will be rewritten from scratch, therefore the versioning of the API was reset (starting from 1.0 with the first successful build).

Crucial API was created to simplify your everyday tasks as a spigot developer and to fill the spigot API's holes by adding many useful APIs for tasks that the spigot API does not incorporate or does so in just a small and insufficient amount.
This way, you can fully concentrate on making your idea come to live in a much shorter time.

## Features
### Chat API
###### Since 1.0
Obviously, it is possible to send messages with Bukkit. But for those who are tired of implementing a method to add prefixes before the messages or translate the color & formatting codes, you can use this API. All you need is to create a Message using the sleek builder pattern and the API takes care of the rest! Additionally, it fully supports the Language API (more about that below), so all your messages can be translated to +100 supported languages!

### Language API
###### Work In Progress
Tired of taking care of those language files and translating them? Although this API won't take over the translation part for you, it takes over the management over these files and already supports +100 languages! All you need to do is create the english file and the API automatically adds any newly created key-value pairs to the present files! Additionally, the API checks your data folder on each start-up for newly created language files and automatically uses them if configured so - that means your end-users can take over the translation part for themselves and translate your plugin to as many languages as we support!

On top of that, although not very precise and not recommended as a full replacement for translators, the API can utilize google's translator API and translate your english language file to all of the supported languages. You can use that as a template for your translators.

### GUI API
###### Work In Progress
Beside many very useful functions that simplify the work with inventories, the API also adds native support for scrolling GUIs, 'browse' history and storage for each individual user as well as inventories specific to various different entities and blocks - GUIs no longer have to belong to players only, but can also be owned by entities and blocks. This let's you easily change the way the player interacts with the world and might be especially useful for RPG like elements and much more.

## Usage
**Maven (recommended)**
1. Copy & Paste one of the following repositories into your `pom.xml` file.

Stable Production Versions:
Recommended repository to use in the most cases. Contains tested and mostly bug-free versions.
```maven
<repository>
  <!-- Stable Production Versions - Recommended -->
  <id>skrypt-releases</id>
  <url>https://repositories.skrypt.net/artifactory/releases</url>
</repository>
```
Unstable Development Versions:
Not recommended. Contains unstable versions full of bugs that might break stuff. Use only for experimental purposes.
```maven
<repository>
  <!-- Unstable Development Versions - Contains bugs and may break stuff. Use only for experimental purposes. -->
  <id>skrypt-snapshots</id>
  <url>https://repositories.skrypt.net/artifactory/snapshots</url>
</repository>
```

2. Copy & paste the following dependency into your `pom.xml` file.
```maven
<dependency>
  <groupId>net.skrypt.spigot</groupId>
  <artifactId>crucialapi</artifactId>
  <version>[Version]</version>
</dependency>
```
3. Replace `[Version]` with the latest stable version. You can find it at the very top of this page or choose a specific version [here](https://repositories.skrypt.net/artifactory/releases).
