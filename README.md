# Introduction to FP in Scala [![Build Status](https://travis-ci.org/ambiata/introduction-to-fp-in-scala.svg)](https://travis-ci.org/ambiata/introduction-to-fp-in-scala)
This is the base project for the workshop.

__note__: please test your environment before you arrive so we can get started quickly on the day.


## Getting started

Before you attend you will need to get a few things
ready and ensure everything is setup properly. `sbt`
is going to do all the heavy lifting though, so
hopefully it is all straight forward, if not, send
us an email via <mark@hibberd.id.au>.


Pre-requisites.

 1. A valid install of java 6+
 2. git
 3. **if you are windows only** install sbt using the [msi installer](http://scalasbt.artifactoryonline.com/scalasbt/sbt-native-packages/org/scala-sbt/sbt/0.13.0/sbt.msi)


Getting scala and validating your environment (for unix):

    git clone https://github.com/markhibberd/introduction-to-fp-in-scala.git
    cd introduction-to-fp-in-scala
    ./sbt "test:compile"


Getting scala and validating your environment (for windows):

    git clone https://github.com/markhibberd/introduction-to-fp-in-scala.git
    cd introduction-to-fp-in-scala
    sbt "test:compile"


For either platform this may take a few minutes. It will:

 1. Download the sbt build tool.
 2. Download the required versions of scala.
 3. Compile the main and test source code.
 4. Run the tests.

You should see green output, no errors and, an exit code of 0.

## Working with scala.

Any good text editor will be sufficient for the course. If you
prefer an IDE, you can use the eclipse based scala-ide,
intellij, or emacs with ensime. There are commented out lines
in `project/plugins.sbt` that will help you get started:

You can generate project files for intellij with (after uncommenting sbt-idea plugin):

    ./sbt 'gen-idea no-classifiers'

You can generate project files for eclipse with (after uncommenting sbteclipse-plugin plugin):

    ./sbt eclipse

If you want to use ensime (after uncommenting ensime-sbt-cmd):

    ./sbt 'ensime generate'

Just note that if you choose eclipse or intellij, have a
backup texteditor as well, because there won't be enough
time to debug any editor issues.


## The Plan

There is about two weeks worth of material available, people with
different backgrounds will progress through at different rates.


### Just enough scala

 - `src/main/scala/intro/Scala.scala`
 - `src/main/scala/intro/CheatSheet.scala`


### What is functional programming?

 - `src/main/scala/intro/Intro.scala`


### Introduction to data structures and higher order functions

#### Examples

 - `src/main/scala/intro/Id.scala`
 - `src/main/scala/intro/Optional.scala`

#### Exercises

 - Lists - `src/main/scala/intro/List.scala`
 - Errors without exceptions - `src/main/scala/intro/Result.scala`


### Intro to Type Classes

#### Example

 - `src/main/scala/intro/Equal.scala`

#### Exercises

 - `src/main/scala/intro/Functor.scala`


### Algebra for fun and profit

 - `src/main/scala/intro/Monoid.scala`

### Property based testing

 - Lists: `src/test/scala/intro/ListProperties.scala`
 - Laws: `src/test/scala/intro/MonoidProperties.scala`

### Parsers

 - `src/main/scala/challenge/Parser.scala`

### Zippers

 - `src/main/scala/challenge/Zippers.scala`

### Lenses

 - `src/main/scala/challenge/Lens.scala` (TBD)

### Patterns in Types

 - `src/main/scala/patterns/Reader.scala`
 - `src/main/scala/patterns/Writer.scala`
 - `src/main/scala/patterns/State.scala`
 - `src/main/scala/patterns/Http.scala`
 - `src/main/scala/patterns/Applicative.scala`
 - `src/main/scala/patterns/Monad.scala`
 - `src/main/scala/patterns/ReaderT.scala`
 - `src/main/scala/patterns/WriterT.scala`
 - `src/main/scala/patterns/StateT.scala`
 - `src/main/scala/patterns/MonadTrans.scala`
 - `src/main/scala/patterns/HttpT.scala`

### Freedom

 - `src/main/scala/challenge/Trampoline.scala` (TBD)
 - `src/main/scala/challenge/Free.scala` (TBD)

### Stream Processing

 - `src/main/scala/challenge/Streams.scala` (TBD)
