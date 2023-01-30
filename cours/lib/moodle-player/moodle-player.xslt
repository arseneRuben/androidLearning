<xsl:transform xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" exclude-result-prefixes="xs" version="2.0">

    <xsl:strip-space elements="pre" />

    <xsl:key name="referenceLink" match="a" use="." />

    <xsl:include href="html.xslt" />

    <xsl:variable name="teaching-assistant-code-style" select="/html/head/meta[@name='teaching-assistant-code-style']/@content" />
    <xsl:variable name="teaching-assistant-menu-level" select="/html/head/meta[@name='teaching-assistant-menu-level']/@content" />
    <xsl:variable name="teaching-assistant-paragraph-bullet" select="/html/head/meta[@name='teaching-assistant-paragraph-bullet']/@content" />
    <xsl:variable name="teaching-assistant-list-class" select="/html/head/meta[@name='teaching-assistant-list-class']/@content" />
    <xsl:variable name="teaching-assistant-list-item-class" select="/html/head/meta[@name='teaching-assistant-list-item-class']/@content" />
    <xsl:variable name="teaching-assistant-h1-class" select="/html/head/meta[@name='teaching-assistant-h1-class']/@content" />
    <xsl:variable name="teaching-assistant-h-indentation-class" select="/html/head/meta[@name='teaching-assistant-h-indentation-class']/@content" />


    <xsl:template name="apply-custom-class">
        <xsl:param name="parameter" />
        <xsl:param name="default" />

        <xsl:attribute name="class">
            <xsl:choose>
                <xsl:when test="$parameter != ''">
                    <xsl:value-of select="$parameter" />
                </xsl:when>
                <xsl:otherwise>
                    <xsl:value-of select="$default" />
                </xsl:otherwise>
            </xsl:choose>
        </xsl:attribute>
    </xsl:template>

    <xsl:variable name="locale-file">
        <xsl:choose>
            <xsl:when test="/html/@lang = 'en'">
                <xsl:text>lang/en.xml</xsl:text>
            </xsl:when>
            <xsl:otherwise>
                <xsl:text>lang/fr.xml</xsl:text>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:variable>
    <xsl:variable name="lang" select="document(string($locale-file))" />

    <xsl:template match="*[@normalize-space]/text()">
        <xsl:value-of select="normalize-space()" />
    </xsl:template>

    <xsl:template match="@*|node()">
        <xsl:copy>
            <xsl:apply-templates select="@*|node()" />
        </xsl:copy>
    </xsl:template>

    <xsl:template match="/">
        <xsl:apply-templates />
    </xsl:template>

    <xsl:template match="html">
        <xsl:copy>
            <xsl:apply-templates />
        </xsl:copy>
    </xsl:template>

    <xsl:template match="head">
        <xsl:element name="head">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

            <xsl:call-template name="link">
                <xsl:with-param name="path" select="'/lib/bootstrap/css/bootstrap.min.css'" />
            </xsl:call-template>
            <xsl:call-template name="link">
                <xsl:with-param name="path" select="concat('/lib/highlight/styles/', $teaching-assistant-code-style, '.css')" />
            </xsl:call-template>
            <xsl:call-template name="link">
                <xsl:with-param name="path" select="'/lib/moodle-player/moodle-player.css'" />
            </xsl:call-template>

            <xsl:call-template name="script">
                <xsl:with-param name="path" select="'/lib/jquery/jquery-3.3.1.min.js'" />
            </xsl:call-template>
            <xsl:call-template name="script">
                <xsl:with-param name="path" select="'/lib/bootstrap/js/bootstrap.min.js'" />
            </xsl:call-template>
            <xsl:call-template name="script">
                <xsl:with-param name="path" select="'/lib/highlight/highlight.pack.js'" />
            </xsl:call-template>
            <xsl:call-template name="script">
                <xsl:with-param name="path" select="'/lib/clipboard/clipboard.min.js'" />
            </xsl:call-template>
            <xsl:call-template name="script">
                <xsl:with-param name="path" select="'/lib/mathjax/tex-chtml-full.js'" />
            </xsl:call-template>

            <link rel="apple-touch-icon" sizes="180x180" href="../lib/favicon/apple-touch-icon.png" />
            <link rel="icon" type="image/png" sizes="32x32" href="../lib/favicon/favicon-32x32.png" />
            <link rel="icon" type="image/png" sizes="16x16" href="../lib/favicon/favicon-16x16.png" />
            <link rel="manifest" href="../lib/favicon/site.webmanifest" />
            <link rel="mask-icon" href="../lib/favicon/safari-pinned-tab.svg" color="#5bbad5" />
            <meta name="msapplication-TileColor" content="#da532c" />
            <meta name="theme-color" content="#000000" />

            <xsl:apply-templates />
        </xsl:element>
    </xsl:template>

    <xsl:template name="link">
        <xsl:param name="path" />
        <xsl:element name="link">
            <xsl:attribute name="rel">stylesheet</xsl:attribute>
            <xsl:attribute name="href">
                <xsl:value-of select="'..'" />
                <xsl:value-of select="$path" />
            </xsl:attribute>
        </xsl:element>
    </xsl:template>

    <xsl:template name="script">
        <xsl:param name="path" />
        <xsl:element name="script">
            <xsl:attribute name="src">
                <xsl:value-of select="'..'" />
                <xsl:value-of select="$path" />
            </xsl:attribute>
            <xsl:value-of select="' '" />
        </xsl:element>
    </xsl:template>

    <xsl:template name="navbar">
        <xsl:param name="title" />
        <xsl:param name="reference-label" />
        <xsl:param name="section" />
        <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggler" aria-controls="navbarToggler" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarToggler">
                <ul class="nav nav-pills mr-auto">
                    <li class="nav-item">
                        <a class="nav-link active" id="course-tab" data-toggle="tab" href="#course" aria-controls="course" aria-selected="true">
                            <xsl:value-of select="$title" />
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="reference-tab" data-toggle="tab" href="#reference" aria-controls="reference" aria-selected="false">
                            <xsl:value-of select="$lang//labels/references" />
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="source-tab" data-toggle="tab" href="#source" aria-controls="source" aria-selected="false">
                            <xsl:value-of select="$lang//labels/sources" />
                        </a>
                    </li>
                    <xsl:if test="//body/@data-presentation-filename != ''">
                        <li class="nav-item">
                            <xsl:variable name="presentationFile" select="//body/@data-presentation-filename" />
                            <a class="nav-link" target="presentation" href="moodle-slides/presentation.html?dataXML={$presentationFile}">
                                <xsl:value-of select="$lang//labels/presentation" />
                            </a>
                        </li>
                    </xsl:if>
                </ul>
                <ul class="navbar-nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                            <xsl:value-of select="$lang//labels/section" />
                        </a>
                        <div class="dropdown-menu dropdown-menu-right dropdown-menu-scroll">
                            <xsl:for-each select="//section">
                                <xsl:element name="a">
                                    <xsl:attribute name="class">
                                        <xsl:value-of select="'dropdown-item'" />
                                        <xsl:value-of select="' badge-secondary'" />
                                    </xsl:attribute>
                                    <xsl:attribute name="href">
                                        <xsl:text>#</xsl:text>
                                        <xsl:call-template name="generate-menu-id">
                                            <xsl:with-param name="title">
                                                <xsl:value-of select="h1/." />
                                            </xsl:with-param>
                                        </xsl:call-template>
                                    </xsl:attribute>
                                    <xsl:value-of select="h1/." />
                                </xsl:element>

                                <xsl:for-each select="article[h2]">
                                    <xsl:variable name="parent-h2-id" select="generate-id(.)" />

                                    <xsl:element name="a">
                                        <xsl:attribute name="class">
                                            <xsl:value-of select="'dropdown-item'" />
                                        </xsl:attribute>
                                        <xsl:attribute name="href">
                                            <xsl:text>#</xsl:text>
                                            <xsl:call-template name="generate-menu-id">
                                                <xsl:with-param name="title">
                                                    <xsl:value-of select="*[1]/." />
                                                </xsl:with-param>
                                            </xsl:call-template>
                                        </xsl:attribute>
                                        <!-- There should be a h2 as first child -->
                                        <xsl:value-of select="*[1]/." />
                                    </xsl:element>

                                    <xsl:if test="$teaching-assistant-menu-level = 3">
                                        <xsl:for-each select="following-sibling::article[h3][generate-id(preceding-sibling::article[h2][1]) = $parent-h2-id]">
                                            <xsl:element name="a">
                                                <xsl:attribute name="class">
                                                    <xsl:value-of select="'dropdown-item pad-left-h3'" />
                                                </xsl:attribute>
                                                <xsl:attribute name="href">
                                                    <xsl:text>#</xsl:text>
                                                    <xsl:call-template name="generate-menu-id">
                                                        <xsl:with-param name="title">
                                                            <xsl:value-of select="*[1]/." />
                                                        </xsl:with-param>
                                                    </xsl:call-template>
                                                </xsl:attribute>
                                                <!-- There should be a h3 as first child -->
                                                <xsl:value-of select="*[1]/." />
                                            </xsl:element>
                                        </xsl:for-each>
                                    </xsl:if>

                                </xsl:for-each>
                            </xsl:for-each>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
    </xsl:template>

    <xsl:template match="body">
        <xsl:copy>
            <xsl:apply-templates select="@*" />
            <xsl:call-template name="navbar">
                <xsl:with-param name="title" select="../head/title" />
            </xsl:call-template>
            <xsl:element name="main">
                <div class="tab-content">
                    <div class="tab-pane fade show active" id="course" role="tabpanel" aria-labelledby="course-tab">
                        <xsl:apply-templates />
                    </div>
                    <div class="tab-pane fade" id="reference" role="tabpanel" aria-labelledby="reference-tab">
                        <xsl:call-template name="reference" />
                    </div>
                    <div class="tab-pane fade" id="source" role="tabpanel" aria-labelledby="source-tab">
                        <xsl:call-template name="source" />
                    </div>
                </div>
            </xsl:element>
            <script>
                <xsl:text disable-output-escaping="yes">
                    <![CDATA[
                        $(document).ready(function () {
                            const codeNodeList = document.querySelectorAll("pre > code");
                            codeNodeList.forEach(function(codeNode) {
                                try {
                                    const codeArray = codeNode.innerHTML.split('\n');

                                    // If the CDATA element is not formatted on a single line: ![CDATA[ example ]]
                                    // And if the CDATA element is formatted on his own line, remove the white space line
                                    if (codeArray.length > 1 && !codeArray[1].replace(/\s/g, '').length) {
                                        codeArray.splice(0,1);
                                        codeArray[0] = codeArray[0].trim();
                                    }

                                    const codeText = codeArray.join('\n');

                                    const pattern = codeText.match(/\s*\n[\t\s]*/);
                                    codeNode.innerHTML = codeText.replace(new RegExp(pattern, "g"), '\n');

                                    hljs.highlightBlock(codeNode);
                                } catch (error) {
                                    console.log('Error while parsing and initializing syntaxe highlight:', error);
                                }
                            });

                            new ClipboardJS('.btn');
                        });
                    ]]>
                </xsl:text>
            </script>
            <xsl:call-template name="version" />
        </xsl:copy>
    </xsl:template>

    <xsl:template name="version">
        <xsl:element name="div">
            <xsl:attribute name="class">alert alert-light build-info</xsl:attribute>
            <xsl:attribute name="role">alert</xsl:attribute>

            <xsl:element name="div">
                <xsl:value-of select="/html/head/meta[@name='teaching-assistant-course-datetime']/@content" />
            </xsl:element>
            <xsl:element name="div">
                <xsl:text>Teaching Assistant</xsl:text>
                <xsl:text>&#x20;</xsl:text>
                <xsl:value-of select="/html/head/meta[@name='teaching-assistant-version']/@content" />
            </xsl:element>

        </xsl:element>
    </xsl:template>

    <xsl:template name="reference">
        <xsl:element name="ul">
            <xsl:for-each select="//section">
                <li>
                    <xsl:element name="h1">
                        <xsl:element name="span">
                            <xsl:attribute name="class">badge badge-secondary</xsl:attribute>
                            <xsl:value-of select="h1" />
                        </xsl:element>
                    </xsl:element>
                    <ul>
                        <xsl:for-each select=".//a">
                            <li>
                                <xsl:element name="a">
                                    <xsl:attribute name="href">
                                        <xsl:value-of select="@href" />
                                    </xsl:attribute>
                                    <xsl:attribute name="target">_blank</xsl:attribute>
                                    <xsl:value-of select="." />
                                </xsl:element>
                            </li>
                        </xsl:for-each>
                    </ul>
                </li>
            </xsl:for-each>
        </xsl:element>
    </xsl:template>

    <xsl:template name="source">
        <xsl:for-each select="//section">
            <xsl:variable name="i" select="position()" />
            <section>
                <xsl:element name="h1">
                    <xsl:element name="span">
                        <xsl:attribute name="class">badge badge-secondary</xsl:attribute>
                        <xsl:value-of select="h1" />
                    </xsl:element>
                </xsl:element>
                <xsl:for-each select="article">
                    <xsl:variable name="j" select="position()" />
                    <xsl:element name="article">
                        <xsl:attribute name="class">contain-h2</xsl:attribute>
                        <xsl:element name="h2">
                            <xsl:element name="span">
                                <xsl:attribute name="class">badge badge-secondary</xsl:attribute>
                                <xsl:value-of select="h2" />
                            </xsl:element>
                        </xsl:element>
                    </xsl:element>
                    <xsl:for-each select="//pre">
                        <xsl:variable name="k" select="position()" />
                        <xsl:element name="article">
                            <xsl:attribute name="class">contain-h3</xsl:attribute>
                            <!-- please kill me as soon as -->
                            <div></div>
                            <xsl:element name="div">
                                <xsl:attribute name="class">card</xsl:attribute>
                                <xsl:element name="div">
                                    <xsl:attribute name="class">card-body</xsl:attribute>
                                    <xsl:element name="h3">
                                        <xsl:attribute name="class">card-title</xsl:attribute>
                                        <xsl:value-of select="code/@data-title" />
                                    </xsl:element>
                                    <xsl:element name="h4">
                                        <xsl:attribute name="class">card-subtitle</xsl:attribute>
                                        <xsl:value-of select="code/@data-subtitle" />
                                    </xsl:element>
                                    <xsl:element name="pre">
                                        <xsl:attribute name="id">
                                            <xsl:value-of select="concat('code_snippet_', $i, '_', $j, '_', $k)" />
                                        </xsl:attribute>
                                        <xsl:element name="code">
                                            <xsl:attribute name="class">
                                                <xsl:value-of select="code/@class" />
                                            </xsl:attribute>
                                            <xsl:value-of select="./code" />
                                        </xsl:element>
                                    </xsl:element>
                                    <xsl:element name="button">
                                        <xsl:attribute name="class">copy-button btn btn-light noprint</xsl:attribute>
                                        <xsl:attribute name="data-clipboard-action">copy</xsl:attribute>
                                        <xsl:attribute name="data-clipboard-target">
                                            <xsl:value-of select="concat('#code_snippet_', $i, '_', $j, '_', $k)" />
                                        </xsl:attribute>
                                        <xsl:value-of select="$lang//labels/copy" />
                                    </xsl:element>
                                </xsl:element>
                            </xsl:element>
                        </xsl:element>
                    </xsl:for-each>
                </xsl:for-each>
            </section>
        </xsl:for-each>
    </xsl:template>

</xsl:transform>