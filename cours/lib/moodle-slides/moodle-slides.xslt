<xsl:transform xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" exclude-result-prefixes="xs" version="2.0">

    <xsl:character-map name="cm">
        <xsl:output-character character="&lt;" string="&amp;lt;" />
        <xsl:output-character character="&gt;" string="&amp;gt;" />
        <xsl:output-character character="&amp;" string="&amp;" />
    </xsl:character-map>

    <xsl:output use-character-maps="cm" />

    <xsl:variable name="moodle-player-folder" select="'../lib/moodle-slides'" />
    <xsl:variable name="moodle-player-code-style" select="/html/head/meta[@name='teaching-assistant-code-style']/@content" />

    <xsl:template match="@*|node()">
        <xsl:copy>
            <xsl:apply-templates select="@*|node()" />
        </xsl:copy>
    </xsl:template>
    <xsl:template match="/">
        <xsl:apply-templates />
    </xsl:template>

    <xsl:template match="head">
        <xsl:element name="head">
            <xsl:element name="title">
                <xsl:value-of select="title" />
            </xsl:element>
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

            <xsl:call-template name="link">
                <xsl:with-param name="path" select="concat('/lib/highlight/styles/', $moodle-player-code-style, '.css')" />
            </xsl:call-template>

            <xsl:call-template name="script">
                <xsl:with-param name="path" select="'/lib/jquery/jquery-3.3.1.min.js'" />
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

            <xsl:call-template name="script">
                <xsl:with-param name="path" select="'/lib/moodle-slides/lib/reveal.js-3.8.0/js/reveal.js'" />
            </xsl:call-template>

            <xsl:call-template name="link">
                <xsl:with-param name="path" select="'/lib/moodle-slides/lib/reveal.js-3.8.0/css/reveal.css'" />
            </xsl:call-template>
            <xsl:call-template name="link">
                <xsl:with-param name="path" select="'/lib/moodle-slides/lib/reveal.js-3.8.0/css/theme/white.css'" />
            </xsl:call-template>

            <xsl:call-template name="link">
                <xsl:with-param name="path" select="'/lib/moodle-slides/moodle-slides.css'" />
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

    <xsl:template match="body">
        <xsl:element name="div">
            <xsl:attribute name="class">reveal</xsl:attribute>
            <xsl:element name="div">
                <xsl:attribute name="class">slides</xsl:attribute>
                <xsl:apply-templates />
            </xsl:element>
        </xsl:element>

        <script>
            <xsl:text disable-output-escaping="yes">
                <![CDATA[
                    $(document).ready(function () {
                        Reveal.initialize({
                            dependencies: [
                                // TODO: ??? how to use xsl variable moodle-player-folder ?
                                { src: '../lib/moodle-slides/lib/reveal.js-3.8.0/plugin/zoom-js/zoom.js', async: false },
                                { src: '../lib/moodle-slides/lib/reveal.js-3.8.0/plugin/menu/menu.js', async: false }
                            ],
                            transition: 'fade',
                            width: "100%",
                            height: "100%",
                            margin: 0,
                            minScale: 0.95,
                            maxScale: 0.95,
                            menu : {
                                titleSelector : 'h1, h2',
                                hideMissingTitles: true,
                                markers: true,
                                openSlideNumber: true,
                                numbers : true
                            }
                        });

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

    <xsl:template match="section">
        <xsl:element name="section">
            <xsl:element name="h1">
                <xsl:value-of select="h1" />
            </xsl:element>
        </xsl:element>
        <xsl:for-each select="article">
            <xsl:element name="section">
                <xsl:attribute name="class">scrollable</xsl:attribute>
                <xsl:apply-templates />
            </xsl:element>
        </xsl:for-each>
    </xsl:template>

    <xsl:template match="pre">
        <pre>
            <xsl:if test="code/@data-title">
                <xsl:element name="h5">
                    <xsl:value-of select="code/@data-title" />
                </xsl:element>
            </xsl:if>
            <xsl:if test="code/@data-subtitle">
                <xsl:element name="h6">
                    <xsl:value-of select="code/@data-subtitle" />
                </xsl:element>
            </xsl:if>
            <xsl:copy-of select="./code" />
        </pre>
    </xsl:template>

    <xsl:template match="ul">
        <xsl:element name="ul">
            <xsl:apply-templates />
        </xsl:element>
    </xsl:template>

    <xsl:template match="li">
        <xsl:element name="li">
            <xsl:apply-templates />
        </xsl:element>
    </xsl:template>

    <xsl:template match="img">
        <xsl:element name="div">
            <xsl:element name="img">
                <xsl:attribute name="src">
                    <xsl:value-of select="@src" />
                </xsl:attribute>
                <xsl:attribute name="alt">
                    <xsl:value-of select="@alt" />
                </xsl:attribute>
            </xsl:element>
        </xsl:element>
    </xsl:template>

    <xsl:template match="h2|h3|h4|h5|h6|p|a">
        <xsl:copy-of select="." />
    </xsl:template>
</xsl:transform>