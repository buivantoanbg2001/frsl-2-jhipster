# FRSL To JHipster

**Prerequisites:**

- Install [Eclipse DSL Tools (Version: 2022-03)](https://www.eclipse.org/downloads/packages/release/2022-03/r/eclipse-ide-java-and-dsl-developers).
- Install plugin Sirius 7.0: _Help -> Eclipse Marketplace -> Search "Sirius 7.0" -> Install -> Next ..._
- Clone [frsl-all repo](https://github.com/vnu-frsl/frsl-all.git).
- Open repo:
  - _File -> Open Project From File System -> Specify to folder 'plugins' -> Deselect the 'plugins' checkbox -> finish_.
  - _File -> Open Project From File System -> Specify to folder 'examples' -> Deselect the 'examples' checkbox -> finish_.

**Usage\:**

- Run runtime: _Right click to any project -> Run As -> Eclipse Application_.
- In runtime environment, create general project: _File -> New Project -> General -> Project -> Next ..._
- In general project, create .frsl file: _Right click -> New -> File -> Set name "test.frsl" -> Finish_
- Open _.frsl_ file -> Right click on white space in editor -> FRSLCS -> Save As -> FRSLAS -> OK.
- Open _.frslas_ file -> Right click on white space in editor -> Frslas2Jdl -> Generate Frsl2Jdl.
