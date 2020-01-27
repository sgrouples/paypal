import LiftModule.{liftVersion, liftEdition}

name := "lift-paypal"

organization := "me.sgrouples"

version := "1.6.0-SG"

liftVersion := "3.4.0"

liftEdition := liftVersion.value.substring(0,3)

moduleName := name.value + "_" + liftEdition.value

scalaVersion := "2.13.1"

crossScalaVersions := Seq("2.13.1", "2.12.10")

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

resolvers += "Java.net Maven2 Repository" at "http://download.java.net/maven/2/"

libraryDependencies ++=
  "net.liftweb"       %%  "lift-webkit"        %  liftVersion.value %  "provided" ::
  "org.specs2"        %%  "specs2-core"        %  "4.8.3"           %  "test" ::
  "commons-httpclient" %  "commons-httpclient" %  "3.1" ::
  Nil

/*publishTo := (version.value.endsWith("SNAPSHOT") match {
 	case true  => Some("snapshots" at "https://oss.sonatype.org/content/repositories/snapshots")
 	case false => Some("releases" at "https://oss.sonatype.org/service/local/staging/deploy/maven2")
  }
)

credentials ++= (for {
  username <- Option(System.getenv().get("SONATYPE_USERNAME"))
  password <- Option(System.getenv().get("SONATYPE_PASSWORD"))
} yield Credentials("Sonatype Nexus Repository Manager", "oss.sonatype.org", username, password)).toSeq

*/
credentials += Credentials(Path.userHome / ".ivy2" / ".meweCredentials")

publishTo := {
    if (version.value.trim.endsWith("SNAPSHOT"))
      Some("Snapshots" at "https://nexus.groupl.es/repository/maven-snapshots/")
    else
      Some("Releases" at "https://nexus.groupl.es/repository/maven-releases/")
}

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
	<url>https://github.com/liftmodules/paypal</url>
	<licenses>
		<license>
	      <name>Apache 2.0 License</name>
	      <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
	      <distribution>repo</distribution>
	    </license>
	 </licenses>
	 <scm>
	    <url>git@github.com:liftmodules/paypal.git</url>
	    <connection>scm:git:git@github.com:liftmodules/paypal.git</connection>
	 </scm>
	 <developers>
	    <developer>
	      <id>liftmodules</id>
	      <name>Lift Team</name>
	      <url>http://www.liftmodules.net</url>
	 	</developer>
	 </developers>
 )
