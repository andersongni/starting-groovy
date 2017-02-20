job ('TESTE') {
  scm {
    git {
      remote {
        url('http://andersongni@bitbucket.org/andersongni/projeto_final.git')
        credentials('b8bf39c9-4e95-4e40-a9ed-b53031279d22')
      }
      branch ('master')
    }
  }
  steps {
  	shell ('python check_versions.py')
  }
}

2.times {
  job('example' + it) {
    steps {
      shell ('echo \"Olá mundo!\"')
    }
  }
}

nestedView('view-teste') {
    views {
        listView('overview') {
            jobs {
                regex(/example.*/)
            }
            columns {
                status()
                weather()
                name()
                lastSuccess()
                lastFailure()
            }
        }
        buildPipelineView('pipeline') {
            selectedJob('project-a-compile')
        }
    }
}
