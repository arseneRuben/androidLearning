<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" version="5.0" encoding="UTF-8" indent="yes" />

    <xsl:template match="@*|node()">
        <xsl:copy>
            <xsl:apply-templates select="@*|node()" />
        </xsl:copy>
    </xsl:template>

    <xsl:template match="/">
        <xsl:apply-templates />
    </xsl:template>

    <xsl:template match="index">
        <xsl:element name="html">
            <xsl:attribute name="lang">en</xsl:attribute>
            <xsl:element name="head">
                <xsl:element name="title">Teaching Assistant - Index</xsl:element>

                <link rel="stylesheet" href="lib/bootstrap/css/bootstrap.min.css" />
                <link rel="stylesheet" href="lib/index-page/index-page.css" />
            </xsl:element>
            <xsl:element name="body">


                <div class="container-fluid">
                    <h1>Teaching assistant</h1>
                    <xsl:call-template name="content" />
                </div>
            </xsl:element>
        </xsl:element>
    </xsl:template>

    <xsl:template name="content">
        <div>
            <div>
                <img src="lib/favicon/android-chrome-512x512.png" alt="logo" />
            </div>

            <div>
                <div class="card bg-light mb-3">
                    <div class="card-body">
                        <h5 class="card-title">Index</h5>
                        <p class="card-text">
                            <xsl:element name="a">
                                <xsl:attribute name="href">
                                    <xsl:value-of select="concat('file:///', @rootPath, '/dist/out/index.html')" />
                                </xsl:attribute>
                                <xsl:text>Documentation</xsl:text>
                            </xsl:element>
                            <xsl:text> avec exemple pour la création du contenu.</xsl:text>
                        </p>
                    </div>
                    <xsl:apply-templates />
                </div>
            </div>

        </div>
    </xsl:template>

    <xsl:template match="languages">
        <xsl:element name="ul">
            <xsl:attribute name="class">list-group list-group-flush</xsl:attribute>
            <xsl:apply-templates />
        </xsl:element>
    </xsl:template>

    <xsl:template match="language">
        <xsl:element name="li">
            <xsl:attribute name="class">list-group-item</xsl:attribute>
            <xsl:value-of select="@nativeName" />
            <xsl:apply-templates />
        </xsl:element>
    </xsl:template>

    <xsl:template match="pages">
        <xsl:element name="ul">
            <xsl:attribute name="class">list-group</xsl:attribute>
            <xsl:apply-templates />
        </xsl:element>
    </xsl:template>

    <xsl:template match="page">
        <xsl:element name="li">
            <xsl:attribute name="class">list-group-item</xsl:attribute>
            <xsl:element name="a">
                <xsl:attribute name="href">
                    <xsl:value-of select="concat(../../@code, '/', @name, @extension)" />
                </xsl:attribute>
                <xsl:attribute name="target">
                    <xsl:text>_blank</xsl:text>
                </xsl:attribute>
                <xsl:value-of select="@name" />
            </xsl:element>
        </xsl:element>
    </xsl:template>

</xsl:stylesheet>