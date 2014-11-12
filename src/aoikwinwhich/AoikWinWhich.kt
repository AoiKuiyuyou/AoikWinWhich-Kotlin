//
package aoikwinwhich

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.util.LinkedHashSet
import java.util.LinkedList

//
object AoikWinWhich {

    fun find_executable(prog: String): List<String> {
        // 8f1kRCu
        val env_var_PATHEXT = System.getenv("PATHEXT")
        /// can be null

        // 6qhHTHF
        // split into a list of extensions
        var ext_s =
            if (env_var_PATHEXT == null)
                listOf<String>()
            else
                env_var_PATHEXT.split(File.pathSeparator).toList()

        // 2pGJrMW
        // strip
        ext_s = ext_s.map({x -> x.trim()})

        // 2gqeHHl
        // remove empty
        ext_s = ext_s.filter({x -> x != ""})

        // 2zdGM8W
        // convert to lowercase
        ext_s = ext_s.map({x -> x.toLowerCase()})

        // 2fT8aRB
        // uniquify
        ext_s = LinkedHashSet(ext_s).toList()
        /// LinkedHashSet keeps the original order.

        // 4ysaQVN
        val env_var_PATH = System.getenv("PATH")
        /// can be null

        // 6mPI0lg
        var dir_path_s =
            if (env_var_PATH == null)
                linkedListOf<String>()
            else
                env_var_PATH.split(File.pathSeparator).toLinkedList()

        // 5rT49zI
        // insert empty dir path to the beginning
        //
        // Empty dir handles the case that |prog| is a path, either relative or
        //  absolute. See code 7rO7NIN.
        dir_path_s.add(0, "")

        // 2klTv20
        // uniquify
        dir_path_s = LinkedHashSet(dir_path_s).toLinkedList()
        /// LinkedHashSet keeps the original order.

        //
        val prog_lc = prog.toLowerCase()

        val prog_has_ext = ext_s.any({ext -> prog_lc.endsWith(ext)})

        // 6bFwhbv
        var exe_path_s = linkedListOf<String>()

        for (dir_path in dir_path_s) {
            // 7rO7NIN
            // synthesize a path with the dir and prog
            val path =
                if (dir_path == "")
                    prog
                else
                    Paths.get(dir_path, prog).toString()

            // 6kZa5cq
            // assume the path has extension, check if it is an executable
            if (prog_has_ext && Files.isRegularFile(Paths.get(path))) {
                 exe_path_s.add(path)
            }

            // 2sJhhEV
            // assume the path has no extension
            for (ext in ext_s) {
                // 6k9X6GP
                // synthesize a new path with the path and the executable extension
                val path_plus_ext = path + ext

                // 6kabzQg
                // check if it is an executable
                if (Files.isRegularFile(Paths.get(path_plus_ext))) {
                    exe_path_s.add(path_plus_ext)
                }
            }
        }

        // 8swW6Av
        // uniquify
        exe_path_s = LinkedHashSet(exe_path_s).toLinkedList()
        /// LinkedHashSet keeps the original order.

        //
        return exe_path_s
    }

    fun main(args: Array<String>) {
        // 9mlJlKg
        // check if one cmd arg is given
        if (args.size != 1) {
            // 7rOUXFo
            // print program usage
            println("""Usage: aoikwinwhich PROG""")
            println()
            println("""#/ PROG can be either name or path""")
            println("""aoikwinwhich notepad.exe""")
            println("""aoikwinwhich C:\Windows\notepad.exe""")
            println("")
            println("""#/ PROG can be either absolute or relative""")
            println("""aoikwinwhich C:\Windows\notepad.exe""")
            println("""aoikwinwhich Windows\notepad.exe""")
            println("")
            println("""#/ PROG can be either with or without extension""")
            println("""aoikwinwhich notepad.exe""")
            println("""aoikwinwhich notepad""")
            println("""aoikwinwhich C:\Windows\notepad.exe""")
            println("""aoikwinwhich C:\Windows\notepad""")

            // 3nqHnP7
            return
        }

        // 9m5B08H
        // get name or path of a program from cmd arg
        val prog = args[0]

        // 8ulvPXM
        // find executables
        val path_s = find_executable(prog)

        // 5fWrcaF
        // has found none, exit
        if (path_s.size == 0) {
            // 3uswpx0
            return
        }

        // 9xPCWuS
        // has found some, output
        val txt = path_s.join("\n")

        println(txt)

        // 4s1yY1b
        return
    }
}

//
fun main(args: Array<String>) {
    AoikWinWhich.main(args)
}
